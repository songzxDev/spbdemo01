package org.songzx.spbdemo01.controller;

import com.alibaba.fastjson.JSON;
import org.songzx.spbdemo01.adapter.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping("/loginSubmit/")
    public @ResponseBody Map<String, Object> loginSubmit(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("returncode", 0);
        map.put("msg", "模拟登录成功！");
        map.put("result", password);
        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
        return map;
    }
}
