package org.songzx.spbdemo01.service.impl;

import org.songzx.spbdemo01.dao.UserDaoI;
import org.songzx.spbdemo01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDao;

    @Override
    public String getUserPwdByUname(String username) throws Exception {
        return userDao.getUserPwdByUname(username);
    }
}
