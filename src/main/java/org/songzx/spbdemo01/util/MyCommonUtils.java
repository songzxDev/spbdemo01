package org.songzx.spbdemo01.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MyCommonUtils {

    public static String getTokenByUnameAndPwd(String username, String password) {
        return DigestUtils.sha1Hex(username + "" + password);
    }

    public static void main(String[] args) {
        System.out.println(MyCommonUtils.getTokenByUnameAndPwd("songzx", "Szx@731918"));
    }
}
