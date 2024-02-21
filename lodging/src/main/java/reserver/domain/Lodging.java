package reserver.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserver.LodgingApplication;
import reserver.domain.LodgingRegistered;
import reserver.domain.RatingUpdated;

@Entity
@Table(name = "Lodging_table")
@Data
//<<< DDD / Aggregate Root
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String owner;

    private Long price;

    private Integer rating;

    @PostPersist
    public void onPostPersist() {
        RatingUpdated ratingUpdated = new RatingUpdated(this);
        ratingUpdated.publishAfterCommit();

        LodgingRegistered lodgingRegistered = new LodgingRegistered(this);
        lodgingRegistered.publishAfterCommit();
    }

    public static LodgingRepository repository() {
        LodgingRepository lodgingRepository = LodgingApplication.applicationContext.getBean(
            LodgingRepository.class
        );
        return lodgingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateAverageRating(ReviewRegistered reviewRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Lodging lodging = new Lodging();
        repository().save(lodging);

        RatingUpdated ratingUpdated = new RatingUpdated(lodging);
        ratingUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reviewRegistered.get???()).ifPresent(lodging->{
            
            lodging // do something
            repository().save(lodging);

            RatingUpdated ratingUpdated = new RatingUpdated(lodging);
            ratingUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
