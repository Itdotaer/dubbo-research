package com.itdotaer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserBeanTest
 *
 * @author jt_hu
 * @date 2018/5/16
 */
public class UserBeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");

        User user = (User) applicationContext.getBean("testBean");

        System.out.println(user.getUserName() + ";" + user.getEmail());
    }

}
