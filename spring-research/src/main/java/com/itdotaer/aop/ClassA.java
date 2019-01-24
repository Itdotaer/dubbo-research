package com.itdotaer.aop;

/**
 * ClassA
 *
 * @author jt_hu
 * @date 2019-01-21
 */
public class ClassA {

    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public void classAFunc() {
        classB.classBFunc();
    }

    public void classAFunc1() {
        classB.classBFunc1();
    }

}
