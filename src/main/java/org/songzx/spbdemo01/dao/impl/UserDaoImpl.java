package org.songzx.spbdemo01.dao.impl;

import org.songzx.spbdemo01.dao.UserDaoI;
import org.songzx.spbdemo01.entity.TbUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDaoI {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String getUserPwdByUname(String username) throws SQLException, Exception {
        String password = "";
        try {
            // queryForMap 查询结果不能为空
            Map<String, Object> map = jdbcTemplate.queryForMap("select password from `userlogin` where loginname=?",
                    new Object[]{username},
                    new int[]{Types.VARCHAR});
            password = (String) map.get("password");
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public String saveUser(TbUserLogin tbUserLogin) throws SQLException, Exception {
        int inNum = jdbcTemplate.update("INSERT INTO `userlogin` (`loginname`, `password`, `email`) VALUES(?, ?, ?)",
                new Object[]{tbUserLogin.getLoginname(), tbUserLogin.getPassword(), tbUserLogin.getEmail()},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
        return inNum + "";
    }
}
