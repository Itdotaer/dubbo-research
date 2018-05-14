package com.itdotaer.dubbo.research.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itdotaer.dubbo.research.provider.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoConsumerController
 *
 * @author jt_hu
 * @date 2018/5/14
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}")
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }

}
