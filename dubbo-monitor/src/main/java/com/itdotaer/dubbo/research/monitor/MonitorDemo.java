package com.itdotaer.dubbo.research.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.MonitorService;

import java.util.List;

/**
 * MonitorDemo
 *
 * @author jt_hu
 * @date 2018/5/15
 */
public class MonitorDemo implements MonitorService {

    private URL url;

    public MonitorDemo(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return this.url;
    }

    public boolean isAvailable() {
        return true;
    }

    public void destroy() {

    }

    public void collect(URL url) {

    }

    public List<URL> lookup(URL url) {
        return null;
    }

}
