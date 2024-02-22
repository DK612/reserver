package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReserveMailSent extends AbstractEvent {

    private Long id;
    private Long userId;
    private String title;
    private String detail;
    private Date alertDt;

    public ReserveMailSent(Email aggregate) {
        super(aggregate);
    }

    public ReserveMailSent() {
        super();
    }
}
//>>> DDD / Domain Event
