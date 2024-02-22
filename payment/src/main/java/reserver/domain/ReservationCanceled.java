package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class ReservationCanceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Boolean isCanceled;
}
