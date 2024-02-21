package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewDeleted extends AbstractEvent {

    private Long id;

    public ReviewDeleted(Review aggregate) {
        super(aggregate);
    }

    public ReviewDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
