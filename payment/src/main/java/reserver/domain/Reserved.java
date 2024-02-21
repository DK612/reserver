package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lodgingId;
    private Date startDt;
    private Date endDt;
}
