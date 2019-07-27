package org.songzx.spbdemo01.dao.impl;

import org.songzx.spbdemo01.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
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
        Map<String, Object> map = jdbcTemplate.queryForMap("select password from `userlogin` where loginname=?",
                new Object[]{username},
                new int[]{Types.VARCHAR});
        if (map != null && !map.isEmpty()) {
            password = (String) map.get("password");
        }
        return password;
    }
}
