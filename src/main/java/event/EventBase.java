package event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.UUID;

// https://github.com/alves-dev/life/blob/main/events/README.md#todos-os-eventos-vao-ter-os-seguintes-campos
public class EventBase {
    private EventType type;

    @JsonProperty("person_id")
    private UUID personId;

    private ZonedDateTime datetime;

    public UUID getPersonId() {
        return personId;
    }

    public ZonedDateTime getDatetime() {
        return datetime;
    }

    protected void setType(EventType type) {
        this.type = type;
    }

    protected void setPersonId(UUID personId) {
        this.personId = personId;
    }

    protected void setDatetime(ZonedDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "EventBase{" +
                "type=" + type +
                ", personId=" + personId +
                ", datetime=" + datetime +
                '}';
    }
}
