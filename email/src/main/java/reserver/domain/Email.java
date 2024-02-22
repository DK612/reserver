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

    public static EmailRepository repository() {
        EmailRepository emailRepository = EmailApplication.applicationContext.getBean(
            EmailRepository.class
        );
        return emailRepository;
    }

    //<<< Clean Arch / Port Method
    @PostPersist
    public static void sendReviewRemindMail(CheckedOut checkedOut) {
        //implement business logic here:
        Email email = new Email();
        email.setUserName(checkedOut.getUserName());
        email.setTitle("Please write your review.");
        email.setDetail("Hi " + checkedOut.getUserName() + " Please write your review.");
        email.setSendDt(new Date());
        repository().save(email);

        ReviewMailSent reviewMailSent = new ReviewMailSent(email);
        reviewMailSent.publishAfterCommit();
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    @PostPersist
    public static void sendReserveCancelMail(PaymentCanceled paymentCanceled) {
        //implement business logic here:

        Email email = new Email();
        email.setUserName(paymentCanceled.getUserName());
        email.setTitle("Your reservation is canceled completely.");
        email.setDetail("Hi " + paymentCanceled.getUserName() + " Your reservation is canceled completely.");
        email.setSendDt(new Date());
        repository().save(email);

        ReserveCancelMailSent reserveCancelMailSent = new ReserveCancelMailSent(email);
        reserveCancelMailSent.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    @PostPersist
    public static void sendReserveMail(Paid paid) {
        //implement business logic here:

        Email email = new Email();
        email.setUserName(paid.getUserName());
        email.setTitle("Your reservation is booked.");
        email.setDetail("Hi " + paid.getUserName() + " Your reservation is booked.");
        email.setSendDt(new Date());
        repository().save(email);

        ReserveMailSent reserveMailSent = new ReserveMailSent(email);
        reserveMailSent.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
