package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class ReviewRegistered extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long reservationId;
    private Integer rating;
    private String detail;
}
