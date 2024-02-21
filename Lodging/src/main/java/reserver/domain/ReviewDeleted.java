package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class ReviewDeleted extends AbstractEvent {

    private Long id;
}
