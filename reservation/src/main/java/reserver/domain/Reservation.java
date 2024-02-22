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

    private String userName;

    private Long lodgingId;

    private Long pricePerDay;

    private Date startDt;

    private Date endDt;

    private Boolean isChecked;

    private Boolean isCanceled;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    @PreUpdate
    public void onPostUpdate() {

        if(this.isCanceled == true) {
            repository().findById(this.getId()).ifPresent(reservation->{
            
                reservation.setIsCanceled(this.isCanceled);
                repository().save(reservation);
                ReservationCanceled reservationCanceled = new ReservationCanceled(reservation);
                reservationCanceled.publishAfterCommit();
             });
        }

        else if(this.isChecked == true) {
            repository().findById(this.getId()).ifPresent(reservation->{
            
                reservation.setIsChecked(this.isChecked);
                repository().save(reservation);
                CheckedIn checkedIn = new CheckedIn(reservation);
                checkedIn.publishAfterCommit();
             });
        }

        else if(this.isChecked == false) {
            repository().findById(this.getId()).ifPresent(reservation->{
            
                reservation.setIsChecked(this.isChecked);
                repository().save(reservation);
                CheckedOut checkedOut = new CheckedOut(reservation);
                checkedOut.publishAfterCommit();
             });
        }
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
