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
    LodgingRepository lodgingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewRegistered'"
    )
    public void wheneverReviewRegistered_UpdateAverageRating(
        @Payload ReviewRegistered reviewRegistered
    ) {
        ReviewRegistered event = reviewRegistered;
        System.out.println(
            "\n\n##### listener UpdateAverageRating : " +
            reviewRegistered +
            "\n\n"
        );

        // Sample Logic //
        Lodging.updateAverageRating(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
