package demo;

import org.springframework.context.ApplicationEvent;

/**
 * TestEvent
 *
 * @author jt_hu
 * @date 2018/5/21
 */
public class TestEvent extends ApplicationEvent {

    private String message;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
