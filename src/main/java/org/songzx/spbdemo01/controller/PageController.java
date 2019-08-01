package org.songzx.spbdemo01.controller;

import org.songzx.spbdemo01.adapter.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/pageBase/")
    public String pageBase(Model model) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra != null) {
            HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
            model.addAttribute(WebSecurityConfig.CURR_USER,
                    request.getSession(true).getAttribute(WebSecurityConfig.CURR_USER));
        }
        return "base.html";
    }

    @GetMapping("/pageLogin/")
    public String pageLogin() {
        return "login.html";
    }

    @GetMapping("/pageBlackWhiteGame/")
    public String pageBlackWhiteGame() {
        return "blackwhitegame.html";
    }
}
