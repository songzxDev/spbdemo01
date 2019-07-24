package org.songzx.spbdemo01.controller;

import org.songzx.spbdemo01.service.MyCatServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCatController {
    @Autowired
    private MyCatServiceI myCatService;

    @RequestMapping("/getMyCatList/")
    public String getMyCatList() {
        String str = "";
        try {
            str = myCatService.getMyCatList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
