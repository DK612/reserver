package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewRegistered extends AbstractEvent {

    private Long id;

    public ReviewRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
