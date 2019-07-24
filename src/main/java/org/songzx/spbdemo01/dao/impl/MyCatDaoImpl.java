package org.songzx.spbdemo01.dao.impl;

import com.alibaba.fastjson.JSON;
import org.songzx.spbdemo01.dao.MyCatDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
@Repository
public class MyCatDaoImpl implements MyCatDaoI {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String getMyCatList() throws SQLException, Exception {
        List list = jdbcTemplate.queryForList("SELECT * FROM `mycat`");
        return JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss");
    }
}
