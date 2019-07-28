package org.songzx.spbdemo01.service.impl;

import org.songzx.spbdemo01.dao.UserDaoI;
import org.songzx.spbdemo01.entity.TbUserLogin;
import org.songzx.spbdemo01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDao;
    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public String getUserPwdByUname(String username) throws Exception {
        return userDao.getUserPwdByUname(username);
    }

    @Override
    @Transactional
    public String saveUser(TbUserLogin tbUserLogin) throws Exception {
        String inNumStr = "0";
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("saveUser" + System.currentTimeMillis());
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            inNumStr = userDao.saveUser(tbUserLogin);
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
        return inNumStr;
    }
}
