package com.itdotaer.impl;

import com.itdotaer.spi.DemoService;

/**
 * ChineseDemoServiceImpl
 *
 * @author jt_hu
 * @date 2018/7/16
 */
public class ChineseDemoServiceImpl implements DemoService {

    /**
     * sayHello
     *
     * @param msg
     * @return
     */
    @Override
    public String sayHello(String msg) {
        return "你好, " + msg;
    }

}
