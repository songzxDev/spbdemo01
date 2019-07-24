package org.songzx.spbdemo01.service.impl;

import org.songzx.spbdemo01.dao.MyCatDaoI;
import org.songzx.spbdemo01.service.MyCatServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myCatService")
public class MyCatServiceImpl implements MyCatServiceI {
    @Autowired
    private MyCatDaoI myCatDao;

    @Override
    public String getMyCatList() throws Exception {
        return myCatDao.getMyCatList();
    }
}
