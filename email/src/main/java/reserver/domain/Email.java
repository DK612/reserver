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
@Table(name = "Email_table")
@Data
//<<< DDD / Aggregate Root
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String title;

    private String detail;

    private Date sendDt;

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

    public static EmailRepository repository() {
        EmailRepository emailRepository = EmailApplication.applicationContext.getBean(
            EmailRepository.class
        );
        return emailRepository;
    }

    //<<< Clean Arch / Port Method
    public static void sendReviewRemindMail(CheckedOut checkedOut) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        ReviewMailSent reviewMailSent = new ReviewMailSent(email);
        reviewMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(checkedOut.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            ReviewMailSent reviewMailSent = new ReviewMailSent(email);
            reviewMailSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void sendReserveMail(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        Email email = new Email();
        repository().save(email);

        ReserveMailSent reserveMailSent = new ReserveMailSent(email);
        reserveMailSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(email->{
            
            email // do something
            repository().save(email);

            ReserveMailSent reserveMailSent = new ReserveMailSent(email);
            reserveMailSent.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
