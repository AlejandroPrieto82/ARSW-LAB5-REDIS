package co.edu.escuelaing.arsw.connection;

import javax.inject.Inject;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PSRedisTemplate extends StringRedisTemplate {
    @Inject
    public PSRedisTemplate(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }
}