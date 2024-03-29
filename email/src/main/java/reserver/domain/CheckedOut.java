package reserver.domain;

import java.util.*;
import lombok.*;
import reserver.domain.*;
import reserver.infra.AbstractEvent;

@Data
@ToString
public class CheckedOut extends AbstractEvent {

    private Long id;
    private String userName;
    private Boolean isChecked;
}
