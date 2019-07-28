package org.songzx.spbdemo01.dao;

import org.songzx.spbdemo01.entity.TbUserLogin;

import java.sql.SQLException;

public interface UserDaoI {
    public String getUserPwdByUname(String username) throws SQLException, Exception;

    public String saveUser(TbUserLogin tbUserLogin) throws SQLException, Exception;
}
