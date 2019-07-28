package org.songzx.spbdemo01.service;

import org.songzx.spbdemo01.entity.TbUserLogin;

public interface UserServiceI {

    public String getUserPwdByUname(String username) throws Exception;

    public String saveUser(TbUserLogin tbUserLogin) throws Exception;
}
