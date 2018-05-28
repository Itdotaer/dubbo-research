package demo.models;

/**
 * User
 *
 * @author jt_hu
 * @date 2018/5/21
 */
public class User {

    private String userName;
    private boolean sex;
    private PhoneNumberModel phoneNumber;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public PhoneNumberModel getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumberModel phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
