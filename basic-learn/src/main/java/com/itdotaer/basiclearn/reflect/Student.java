package com.itdotaer.basiclearn.reflect;

/**
 * Student
 *
 * @author jt_hu
 * @date 2019-01-23
 */
public class Student extends Person {
    private String school;
    public String des;

    public String getSchool() {
        return school;
    }

    private void setSchool(String school) {
        this.school = school;
    }
}
