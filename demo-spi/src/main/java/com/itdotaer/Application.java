package com.itdotaer;

import com.itdotaer.spi.DemoService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Application
 *
 * @author jt_hu
 * @date 2018/7/16
 */
public class Application {

    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);

        Iterator<DemoService> iterator = serviceLoader.iterator();

        while (iterator != null && iterator.hasNext()) {
            DemoService demoService = iterator.next();

            System.out.println("Class:" + demoService.getClass().getName() + "; sayHello:"
                    + demoService.sayHello(" hello world"));
        }
    }

}
