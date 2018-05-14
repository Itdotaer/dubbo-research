import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboConsumerDemo
 *
 * @author jt_hu
 * @date 2018/5/14
 */
@SpringBootApplication(scanBasePackages = "com.itdotaer.dubbo.research.consumer")
public class DubboConsumerDemo {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerDemo.class, args);
    }

}
