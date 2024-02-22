package reserver.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserver.PaymentApplication;
import reserver.domain.Paid;
import reserver.domain.PaymentCanceled;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private Long reservationId;

    private BigDecimal amount;

    private Date payDt;

    private Date refundDt;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();

        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void pay(Reserved reserved) {
        
        Payment payment = new Payment();
        payment.setUserName(reserved.getUserName());
        payment.setReservationId(reserved.getId());
        Long differenceInMillis = reserved.getEndDt().getTime() - reserved.getStartDt().getTime();
        Long days = (differenceInMillis / (24 * 60 * 60 * 1000L)) % 365;
        Long amount = reserved.getPricePerDay() * days;
        payment.setAmount(new BigDecimal(amount));
        payment.setPayDt(new Date());
        repository().save(payment);
    }

    public static void refund(ReservationCanceled reservationCanceled) {
        
        Payment payment = new Payment();
        payment.setUserName(reservationCanceled.getUserName());
        payment.setReservationId(reservationCanceled.getId());
        Long differenceInMillis = reservationCanceled.getEndDt().getTime() - reservationCanceled.getStartDt().getTime();
        Long days = (differenceInMillis / (24 * 60 * 60 * 1000L)) % 365;
        Long amount = reservationCanceled.getPricePerDay() * days;
        payment.setAmount(new BigDecimal(-amount));
        payment.setRefundDt(new Date());
        repository().save(payment);
    }
}
//>>> DDD / Aggregate Root
