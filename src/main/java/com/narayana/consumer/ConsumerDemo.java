package com.narayana.consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class ConsumerDemo {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "sub");
        SpringApplication.run(ConsumerDemo.class, args);
    }

    static class TestConsumer {

        private final Log logger = LogFactory.getLog(getClass());

        @Bean
        public Consumer<String> receive() {
            return s -> logger.info("Data received..." + s);
        }
    }
}

