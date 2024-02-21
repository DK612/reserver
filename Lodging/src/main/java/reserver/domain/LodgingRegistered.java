package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LodgingRegistered extends AbstractEvent {

    private Long id;

    public LodgingRegistered(Lodging aggregate) {
        super(aggregate);
    }

    public LodgingRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
