package org.songzx.spbdemo01.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCommonUtils {

    public static String getTokenByUnameAndPwd(String username, String password) {
        return DigestUtils.sha1Hex(username + "" + password);
    }

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }


    public static void main(String[] args) {
        System.out.println(MyCommonUtils.getTokenByUnameAndPwd("songzx", "Szx@731918"));
    }
}
