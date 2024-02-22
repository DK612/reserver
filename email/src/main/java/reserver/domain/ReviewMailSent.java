package reserver.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewMailSent extends AbstractEvent {

    private Long id;
    private String userName;
    private String title;
    private String detail;
    private Date alertDt;

    public ReviewMailSent(Email aggregate) {
        super(aggregate);
    }

    public ReviewMailSent() {
        super();
    }
}
//>>> DDD / Domain Event
