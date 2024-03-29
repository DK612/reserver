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
    private String userName;
    private Long lodgingId;
    private Integer rating;
    private String detail;

    public ReviewRegistered(Review aggregate) {
        super(aggregate);
    }

    public ReviewRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
