package org.songzx.spbdemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/pageBase/")
    public String pageBase() {
        return "base.html";
    }

    @RequestMapping("/pageLogin/")
    public String pageLogin() {
        return "login.html";
    }
}
