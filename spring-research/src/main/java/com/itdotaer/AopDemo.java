package com.itdotaer;

import com.itdotaer.aop.ClassA;
import com.itdotaer.aop.ClassB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AopDemo
 *
 * @author jt_hu
 * @date 2019-01-21
 */
public class AopDemo {
    public static final void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");

        ClassA classA = ctx.getBean(ClassA.class);
        classA.classAFunc();

        ClassA classA1 = ctx.getBean(ClassA.class);
        classA.classAFunc1();

//        ClassB classB = ctx.getBean(ClassB.class);
//        classB.classBFunc1();

    }
}
