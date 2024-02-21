package reserver.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserver.ReservationApplication;
import reserver.domain.CheckedIn;
import reserver.domain.CheckedOut;
import reserver.domain.ReservationCanceled;
import reserver.domain.Reserved;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long lodgingId;

    private Long pricePerDay;

    private Date startDt;

    private Date endDt;

    private Boolean isChecked;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CheckedOut checkedOut = new CheckedOut(this);
        checkedOut.publishAfterCommit();

        CheckedIn checkedIn = new CheckedIn(this);
        checkedIn.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        ReservationCanceled reservationCanceled = new ReservationCanceled(this);
        reservationCanceled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
