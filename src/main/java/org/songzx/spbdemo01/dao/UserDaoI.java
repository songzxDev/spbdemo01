package org.songzx.spbdemo01.dao;

import java.sql.SQLException;

public interface UserDaoI {
    public String getUserPwdByUname(String username) throws SQLException, Exception;
}
