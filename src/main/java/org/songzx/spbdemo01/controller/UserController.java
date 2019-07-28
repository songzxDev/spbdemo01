package org.songzx.spbdemo01.controller;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.songzx.spbdemo01.adapter.WebSecurityConfig;
import org.songzx.spbdemo01.entity.TbUserLogin;
import org.songzx.spbdemo01.service.UserServiceI;
import org.songzx.spbdemo01.util.MyCommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceI userService;

    @PostMapping("/loginSubmit/")
    public @ResponseBody
    Map<String, Object> loginSubmit(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>(16);
        String okPwd = "";
        try {
            okPwd = userService.getUserPwdByUname(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (okPwd.trim().length() > 0 && password.equals(okPwd)) {
            map.put("returncode", 0);
            map.put("msg", "模拟登录成功！");
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, MyCommonUtils.getTokenByUnameAndPwd(username, password));
            session.setAttribute(WebSecurityConfig.CURR_USER, username);
        } else {
            map.put("returncode", 100);
            map.put("msg", "模拟登录失败，密码不正确！");
        }

        return map;
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/pageLogin/";
    }

    @PostMapping("/saveUser/")
    public @ResponseBody
    Map<String, Object> saveUser(@RequestBody TbUserLogin tbUserLogin) {
        Map<String, Object> map = new LinkedHashMap<>(16);
        map.put("result", "0");
        if (StringUtils.isBlank(tbUserLogin.getLoginname())) {
            map.put("returncode", 101);
            map.put("msg", "loginname参数不能为空！");
        } else if (StringUtils.isBlank(tbUserLogin.getPassword())) {
            map.put("returncode", 102);
            map.put("msg", "password参数不能为空！");
        } else if (StringUtils.isBlank(tbUserLogin.getEmail()) || !MyCommonUtils.checkEmail(tbUserLogin.getEmail())) {
            map.put("returncode", 103);
            map.put("msg", "email参数不能为空且为邮箱的标准格式！");
        } else {
            try {
                if (StringUtils.isBlank(userService.getUserPwdByUname(tbUserLogin.getLoginname()))) {
                    String inNumStr = userService.saveUser(tbUserLogin);
                    map.put("returncode", 0);
                    map.put("msg", "用户信息保存成功！");
                    map.put("result", inNumStr);
                } else {
                    map.put("returncode", 100);
                    map.put("msg", "用户信息存储失败：该用户名信息【${username}】已存在！".replace("${username}", tbUserLogin.getLoginname()));
                }

            } catch (Exception e) {
                map.put("returncode", -1);
                map.put("msg", "用户信息存储失败：" + e.getMessage());
            }
        }
        return map;

    }
}
