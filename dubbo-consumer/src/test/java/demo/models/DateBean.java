package demo.models;

import java.util.Date;

/**
 * demo.models.DateBean
 *
 * @author jt_hu
 * @date 2018/5/17
 */
public class DateBean {

    private Date dateValue;
    private String message;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
