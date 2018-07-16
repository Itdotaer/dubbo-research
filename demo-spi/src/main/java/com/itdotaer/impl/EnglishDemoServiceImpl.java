package com.itdotaer.impl;

import com.itdotaer.spi.DemoService;

/**
 * EnglishDemoServiceImpl
 *
 * @author jt_hu
 * @date 2018/7/16
 */
public class EnglishDemoServiceImpl implements DemoService {

    /**
     * sayHello
     *
     * @param msg
     * @return
     */
    @Override
    public String sayHello(String msg) {
        return "Hello, " + msg;
    }

}
