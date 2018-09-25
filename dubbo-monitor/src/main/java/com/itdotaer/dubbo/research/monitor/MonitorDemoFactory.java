package com.itdotaer.dubbo.research.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;

/**
 * MonitorDemoFactory
 *
 * @author jt_hu
 * @date 2018/5/15
 */
public class MonitorDemoFactory implements MonitorFactory {
    @Override
    public Monitor getMonitor(URL url) {
        return null;
    }

//    @Override
//    public MonitorDemo getMonitor(URL url) {
//        return new MonitorDemo(url);
//    }

}
