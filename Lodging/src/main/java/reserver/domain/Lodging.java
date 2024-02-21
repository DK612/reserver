package reserver.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserver.LodgingApplication;
import reserver.domain.RatingUpdated;

@Entity
@Table(name = "Lodging_table")
@Data
//<<< DDD / Aggregate Root
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String placeName;

    private String infomation;

    private String address;

    private Long owner;

    private Long price;

    private Integer rating;

    @PostPersist
    public void onPostPersist() {
        RatingUpdated ratingUpdated = new RatingUpdated(this);
        ratingUpdated.publishAfterCommit();
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

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewRegistered.get???()).ifPresent(lodging->{
            
            lodging // do something
            repository().save(lodging);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateAverageRating(ReviewDeleted reviewDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Lodging lodging = new Lodging();
        repository().save(lodging);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewDeleted.get???()).ifPresent(lodging->{
            
            lodging // do something
            repository().save(lodging);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
