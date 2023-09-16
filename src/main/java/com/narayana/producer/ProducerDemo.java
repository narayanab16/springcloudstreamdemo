package com.narayana.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

@SpringBootApplication
public class ProducerDemo {

    public static void main(String[] args) {
        //-Dspring.profiles.active=pub
        System.setProperty("spring.profiles.active", "pub");
        SpringApplication.run(ProducerDemo.class, args);
    }

    static class TestProducer {
        private final Log logger = LogFactory.getLog(getClass());
        private AtomicBoolean semaphore = new AtomicBoolean(true);

        @Bean
        public Supplier<String> sendTestData() {
            return () -> {
                try {
                    Thread.sleep(1000 * 10);

                    String x = this.semaphore.getAndSet(!this.semaphore.get()) ? "foo-" + (int)(Math.random() * 1000) : "bar-" + (int)(Math.random() * 1000);;
                    logger.info("Data sent : " + x);
                    return x;
                }catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            };
        }
    }
}

