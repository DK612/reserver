package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private String userName;
    private Long reservationId;
    private Object amount;
    private Date payDt;
    private Date refundDt;
}
