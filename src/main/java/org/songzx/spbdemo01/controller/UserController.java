package org.songzx.spbdemo01.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.songzx.spbdemo01.adapter.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping("/loginSubmit/")
    public @ResponseBody
    Map<String, Object> loginSubmit(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>(16);

        if(password.equals(DigestUtils.sha1Hex("abc"))) {
            map.put("returncode", 0);
            map.put("msg", "模拟登录成功！");
        } else {
            map.put("returncode", 100);
            map.put("msg", "模拟登录失败，密码不正确！");
        }
        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
        return map;
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/pageLogin/";
    }
}
