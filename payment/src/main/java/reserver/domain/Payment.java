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

    private Long userId;

    private Long reservationId;

    private BigDecimal amount;

    private Date payDt;

    private Date refundDt;

    public static void pay(Reserved reserved) {
        
        Payment payment = new Payment();
        payment.setUserId(reserved.getUserId());
        payment.setReservationId(reserved.getId());
        Long differenceInMillis = reserved.getEndDt().getTime() - reserved.getStartDt().getTime()
        Long days = (differenceInMillis / (24 * 60 * 60 * 1000L)) % 365;
        Long amount = reserved.getPricePerDay() * days;
        payment.setAmount(new BigDecimal(amount));
        payment.setPayDt(new Date());
        repository().save(payment);
    }

    public static void refund(Reserved reserved) {
        
        Payment payment = new Payment();
        payment.setUserId(reserved.getUserId());
        payment.setReservationId(reserved.getId());
        Long differenceInMillis = reserved.getEndDt().getTime() - reserved.getStartDt().getTime()
        Long days = (differenceInMillis / (24 * 60 * 60 * 1000L)) % 365;
        Long amount = reserved.getPricePerDay() * days;
        payment.setAmount(new BigDecimal(-amount));
        payment.setRefundDt(new Date());
        repository().save(payment);
    }



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
}
//>>> DDD / Aggregate Root
