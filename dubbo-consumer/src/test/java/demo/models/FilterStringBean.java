package demo.models;

/**
 * FilterStringBean
 *
 * @author jt_hu
 * @date 2018/5/18
 */
public class FilterStringBean {

    private String conStr;
    private String userName;
    private String password;

    public String getConStr() {
        return conStr;
    }

    public void setConStr(String conStr) {
        this.conStr = conStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "conStr:" + this.conStr + "; userName:" + this.userName + "; password:" + this.password;
    }
}
