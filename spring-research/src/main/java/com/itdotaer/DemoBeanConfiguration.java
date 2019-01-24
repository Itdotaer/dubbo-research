package com.itdotaer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DemoBeanConfiguration
 *
 * @author jt_hu
 * @date 2019-01-11
 */
@Configuration
public class DemoBeanConfiguration {

    @Bean(name = "testBean1")
    public User testBean() {
        return new User();
    }

}
