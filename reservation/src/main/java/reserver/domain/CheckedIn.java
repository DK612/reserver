package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CheckedIn extends AbstractEvent {

    private Long id;
    private Long userId;
    private Boolean isChecked;

    public CheckedIn(Reservation aggregate) {
        super(aggregate);
    }

    public CheckedIn() {
        super();
    }
}
//>>> DDD / Domain Event
