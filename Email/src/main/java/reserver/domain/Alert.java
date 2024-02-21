package reserver.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserver.EmailApplication;
import reserver.domain.ReserveCancelMailSent;
import reserver.domain.ReserveMailSent;
import reserver.domain.ReviewMailSent;

@Entity
@Table(name = "Alert_table")
@Data
//<<< DDD / Aggregate Root
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String title;

    private String detail;

    private Date alertDt;

    @PostPersist
    public void onPostPersist() {
        ReserveCancelMailSent reserveCancelMailSent = new ReserveCancelMailSent(
            this
        );
        reserveCancelMailSent.publishAfterCommit();

        ReviewMailSent reviewMailSent = new ReviewMailSent(this);
        reviewMailSent.publishAfterCommit();

        ReserveMailSent reserveMailSent = new ReserveMailSent(this);
        reserveMailSent.publishAfterCommit();
    }

    public static AlertRepository repository() {
        AlertRepository alertRepository = EmailApplication.applicationContext.getBean(
            AlertRepository.class
        );
        return alertRepository;
    }

    //<<< Clean Arch / Port Method
    public static void sendReviewRemindMail(CheckedOut checkedOut) {
        //implement business logic here:

        /** Example 1:  new item 
        Alert alert = new Alert();
        repository().save(alert);

        ReviewMailSent reviewMailSent = new ReviewMailSent(alert);
        reviewMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(checkedOut.get???()).ifPresent(alert->{
            
            alert // do something
            repository().save(alert);

            ReviewMailSent reviewMailSent = new ReviewMailSent(alert);
            reviewMailSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void sendReserveMail(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        Alert alert = new Alert();
        repository().save(alert);

        ReserveMailSent reserveMailSent = new ReserveMailSent(alert);
        reserveMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(alert->{
            
            alert // do something
            repository().save(alert);

            ReserveMailSent reserveMailSent = new ReserveMailSent(alert);
            reserveMailSent.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
