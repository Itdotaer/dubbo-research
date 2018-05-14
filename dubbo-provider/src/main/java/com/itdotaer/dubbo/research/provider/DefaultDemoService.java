package com.itdotaer.dubbo.research.provider;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * DefaultDemoService
 *
 * @author jt_hu
 * @date 2018/5/14
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        cache = "lru")
public class DefaultDemoService implements DemoService {

    /**
     * Say Hello Service Interface
     *
     * @param name
     * @return
     */
    public String sayHello(String name) {
        return "Hello " + name + " (from Spring Boot) ";
    }

}
