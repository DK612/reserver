package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CheckedOut extends AbstractEvent {

    private Long id;
    private Long userIName;
    private Boolean isChecked;

    public CheckedOut(Reservation aggregate) {
        super(aggregate);
    }

    public CheckedOut() {
        super();
    }
}
//>>> DDD / Domain Event
