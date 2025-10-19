package co.edu.escuelaing.arsw.connection;

import javax.inject.Inject;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class PSRedisListenerContainer extends RedisMessageListenerContainer {
    @Inject
    PSRedisListenerContainer(RedisConnectionFactory connectionFactory) {
        this.setConnectionFactory(connectionFactory);
    }
}