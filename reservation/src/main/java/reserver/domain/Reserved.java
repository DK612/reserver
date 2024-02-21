package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lodgingId;
    private Date startDt;
    private Date endDt;

    public Reserved(Reservation aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
//>>> DDD / Domain Event
