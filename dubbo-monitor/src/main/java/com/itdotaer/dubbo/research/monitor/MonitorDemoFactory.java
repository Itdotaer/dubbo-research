package com.itdotaer.dubbo.research.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.MonitorFactory;

/**
 * MonitorDemoFactory
 *
 * @author jt_hu
 * @date 2018/5/15
 */
public class MonitorDemoFactory implements MonitorFactory {

    @Override
    public MonitorDemo getMonitor(URL url) {
        return new MonitorDemo(url);
    }

}
