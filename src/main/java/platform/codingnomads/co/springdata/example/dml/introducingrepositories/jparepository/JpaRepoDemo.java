package platform.codingnomads.co.springdata.example.dml.introducingrepositories.jparepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;

import java.util.List;

@SpringBootApplication
public class JpaRepoDemo implements CommandLineRunner {

    @Autowired
    SoftDrinkRepo softDrinkRepo;

    public static void main(String[] args) {
        SpringApplication.run(JpaRepoDemo.class);
    }

    @Override
    public void run(String... args) throws Exception {
        SoftDrink fanta = SoftDrink.builder().name("Fanta").rating(10).build();
        SoftDrink coke = SoftDrink.builder().name("Coca-Cola").rating(4).build();
        SoftDrink drPepper = SoftDrink.builder().name("Dr. Pepper").rating(1).build();
        SoftDrink pepsi = SoftDrink.builder().name("Pepsi").rating(7).build();
        SoftDrink sevenUp = SoftDrink.builder().name("7-Up").rating(6).build();
        SoftDrink tonic = SoftDrink.builder().name("Tonic Quater").rating(5).build();
        SoftDrink lime = SoftDrink.builder().name("Lime juice").rating(7).build();
        SoftDrink passion = SoftDrink.builder().name("Fanta-Passion").rating(2).build();

        //save single entity instance
        fanta = softDrinkRepo.save(fanta);

        //save multiple entity instances at a time
        List<SoftDrink> insertedSoftDrinks = softDrinkRepo.saveAll(List.of(coke, drPepper));

        //Saving new entity instances.
        List<SoftDrink> insertedSoftDrinks2 = softDrinkRepo.saveAll(List.of(pepsi, sevenUp, tonic, lime, passion));

        //make sure all entities are actually saved to the database
        softDrinkRepo.flush();

        //update coke and drPepper to have rating 0 in the database
        for (SoftDrink sd : insertedSoftDrinks) {
            sd.setRating(0);
            softDrinkRepo.save(sd);
        }

        //updating pepsi to passion to have a rating of 5
        for (SoftDrink sd2 : insertedSoftDrinks2) {
            sd2.setRating(5);
            softDrinkRepo.save(sd2);
        }

        System.out.println("ALL SOFT DRINKS IN DESCENDING ORDER BASED ON ID");
        //get all soft drinks in ascending order and print toString() to the console
        softDrinkRepo.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(System.out::println);

        //find all using an example
        System.out.println("FINDING ALL USING EXAMPLE");
        softDrinkRepo.findAll(
                        Example.of(
                                //probe soft drink to match results with
                                SoftDrink.builder().rating(0).build(),
                                //ask that database entries that match any of the fields in the probe be returned
                                ExampleMatcher.matchingAny())
                )
                .forEach(System.out::println);

        //create page request to paginate through these soft drinks. note that the first page is indicated using a 0
        PageRequest pageRequest = PageRequest.of(0, 2);

        System.out.println("FIRST PAGE");
        //get first page
        Page<SoftDrink> page = softDrinkRepo.findAll(pageRequest);
        page.getContent().forEach(System.out::println);

        System.out.println("SECOND PAGE");
        //get second page
        page = softDrinkRepo.findAll(pageRequest.next());
        page.getContent().forEach(System.out::println);

        //delete all soft drinks in a batch
        softDrinkRepo.deleteAllInBatch();
    }
}