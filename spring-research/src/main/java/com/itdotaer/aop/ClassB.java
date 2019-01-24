package com.itdotaer.aop;

/**
 * ClassB
 *
 * @author jt_hu
 * @date 2019-01-21
 */
public class ClassB {

    public void classBFunc() {
        System.out.println("classBFunc");
        classBFunc1();
    }

    @Method
    public void classBFunc1() {
        System.out.println("classBFunc1");
    }
}
