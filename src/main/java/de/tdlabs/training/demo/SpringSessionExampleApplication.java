package de.tdlabs.training.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@Import(CustomRedisSessionConfig.class)
public class SpringSessionExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionExampleApplication.class, args);
    }
}
