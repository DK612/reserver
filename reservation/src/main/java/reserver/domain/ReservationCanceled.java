package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationCanceled extends AbstractEvent {

    private Long id;
    private String userName;
    private Long lodgingId;
    private Long pricePerDay;
    private Date startDt;
    private Date endDt;
    private Boolean isChecked;
    private Boolean isCanceled;

    public ReservationCanceled(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
