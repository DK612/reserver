package reserver.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserver.config.kafka.KafkaProcessor;
import reserver.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AlertRepository alertRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CheckedOut'"
    )
    public void wheneverCheckedOut_SendReviewRemindMail(
        @Payload CheckedOut checkedOut
    ) {
        CheckedOut event = checkedOut;
        System.out.println(
            "\n\n##### listener SendReviewRemindMail : " + checkedOut + "\n\n"
        );

        // Sample Logic //
        Alert.sendReviewRemindMail(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_SendReserveMail(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener SendReserveMail : " + paid + "\n\n"
        );

        // Sample Logic //
        Alert.sendReserveMail(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentCanceled'"
    )
    public void wheneverPaymentCanceled_SendReserveCancelMail(
        @Payload PaymentCanceled paymentCanceled
    ) {
        PaymentCanceled event = paymentCanceled;
        System.out.println(
            "\n\n##### listener SendReserveCancelMail : " +
            paymentCanceled +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
