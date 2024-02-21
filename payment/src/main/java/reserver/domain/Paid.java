package reserver.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long reservationId;
    private BigDecimal amount;
    private Date payDt;

    public Paid(Payment aggregate) {
        super(aggregate);
    }

    public Paid() {
        super();
    }
}
//>>> DDD / Domain Event
