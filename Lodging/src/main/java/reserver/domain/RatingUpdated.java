package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RatingUpdated extends AbstractEvent {

    private Long id;

    public RatingUpdated(Lodging aggregate) {
        super(aggregate);
    }

    public RatingUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
