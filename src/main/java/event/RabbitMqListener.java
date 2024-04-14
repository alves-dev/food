package event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@ApplicationScoped
public class RabbitMqListener {

    private final ObjectMapper objectMapper;
    private final Event<EventBase> eventPub;

    @Inject
    public RabbitMqListener(ObjectMapper objectMapper, Event<EventBase> eventPub) {
        this.objectMapper = objectMapper;
        this.eventPub = eventPub;
    }

    private final Logger log = LoggerFactory.getLogger(RabbitMqListener.class);

    @Transactional
    @Incoming("food")
    public void consumeMessage(byte[] message) {
        String messageString = new String(message);
        try {
            JsonNode node = objectMapper.readTree(messageString);
            String eventTypeValue = node.get("type").asText();

            Class<? extends EventBase> eventClass = EventType.valueOf(eventTypeValue).getEventClass();
            EventBase event = objectMapper.readValue(messageString, eventClass);

            eventPub.fire(event);
        } catch (Exception e) {
            log.warn("[RabbitMqListener] Error parsing: {}", messageString);
            log.warn(e.toString());
        }
    }

    void onStart(@Observes StartupEvent ev) {
        log.info("Iniciando o serviço de consumo do RabbitMQ.");
    }

    void onStop(@Observes ShutdownEvent ev) {
        log.info("Encerrando o serviço de consumo do RabbitMQ.");
    }
}
