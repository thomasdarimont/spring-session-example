package de.tdlabs.training.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.ExpiringSession;

/**
 * Customizes the default spring-boot / spring-session configuration for redis.
 * <p><b>Note</b> that this config class needs to be imported via {@link org.springframework.context.annotation.Import} in order
 * to be loaded in the correct order to be able to override the Spring Bean Definition provided by Spring Session's {@link org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration}.</p>
 * <p>
 * <p>You <b>must</b> not add {@link org.springframework.context.annotation.Configuration} since it messes up the order
 * in which the Bean definitions are pulled-in. With the {@link org.springframework.context.annotation.Configuration} annotation the
 * bean-definition from Spring Session would always take precedence over {@link #sessionRedisTemplate(RedisConnectionFactory)}.</p>
 * <ul>
 * <li>Configures lettuce as Redis Driver</li>
 * <li>Redefines the <code>sessionRedisTemplate</code> used for storing sessions tu use JSON Serialization</li>
 * </ul>
 */
class CustomRedisSessionConfig {

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, ExpiringSession> sessionRedisTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, ExpiringSession> template = new RedisTemplate<String, ExpiringSession>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        //JSON Serializer for HashValues
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
