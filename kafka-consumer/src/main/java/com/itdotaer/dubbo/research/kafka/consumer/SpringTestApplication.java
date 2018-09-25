package com.itdotaer.dubbo.research.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * SpringApplication
 *
 * @author jt_hu
 * @date 2018/8/17
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.itdotaer.dubbo.research.kafka.consumer")
public class SpringTestApplication {

    public static void main(String[] args) {
        //test
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @KafkaListener(groupId = "spring-test", topics = "test")
    void listener(ConsumerRecord<String, String> data) {
        System.out.println("消费者线程："
                + Thread.currentThread().getName()
                + "[ 消息 来自kafkatopic："
                + data.topic()+",分区："
                + data.partition()
                + " ，委托时间："
                + data.timestamp()+"]消息内容如下：");
        System.out.println(data.value());
    }

}
