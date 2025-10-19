package co.edu.escuelaing.arsw.producer;

import co.edu.escuelaing.arsw.connection.PSRedisListenerContainer;
import co.edu.escuelaing.arsw.connection.PSRedisTemplate;
import co.edu.escuelaing.arsw.receiver.Receiver;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Inject
    private ApplicationContext appContext;

    @Inject
    private PSRedisTemplate template;

    @Inject
    private PSRedisListenerContainer container;

    @Override
    public void run(String... args) throws Exception {
        for (int j = 0; j < 7; j++) {
            Receiver receiver = appContext.getBean(Receiver.class);
            container.addMessageListener(receiver, new PatternTopic("PSChannel"));
        }

        Thread.sleep(500);

        int i = 0;
        while (i < 6) {
            i = i + 1;
            LOGGER.info("Sending message... {}", i);
            template.convertAndSend("PSChannel", "Hello from Redis! Message " + i);
            Thread.sleep(500);
        }

        System.exit(0);
    }
}
