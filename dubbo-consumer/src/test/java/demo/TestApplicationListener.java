package demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * TestApplicationListener
 *
 * @author jt_hu
 * @date 2018/5/21
 */
public class TestApplicationListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof TestEvent) {
            TestEvent testEvent = (TestEvent) applicationEvent;
            testEvent.print();
        }

        if (applicationEvent instanceof ContextRefreshedEvent) {
            System.out.println("Spring ContextRefreshedEvent");
        }
    }
}
