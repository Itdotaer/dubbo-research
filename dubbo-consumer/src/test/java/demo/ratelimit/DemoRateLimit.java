package demo.ratelimit;

import demo.ratelimit.annotation.ServiceLimit;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * DemoRateLimit
 *
 * @author jt_hu
 * @date 2018/6/26
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"demo.ratelimit"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoRateLimit implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @ServiceLimit
    public static void test() {
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
