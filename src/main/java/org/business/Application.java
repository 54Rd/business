package org.business;

import org.business.Config.SecretKeySettings;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by wangz on 2016/12/6.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties({SecretKeySettings.class})
public class Application implements CommandLineRunner{

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
