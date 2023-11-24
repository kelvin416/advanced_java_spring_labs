package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ComputerApplication implements CommandLineRunner {

    @Autowired
    ComputerRepo computerRepo;

    @Autowired
    UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(ComputerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        final User kelvin = User.builder().name("Kelvin").age(27).build();
        final User joan = User.builder().name("Joan").age(30).build();
        final User ray = User.builder().name("Ray").age(24).build();
        final User troy = User.builder().name("Troy").age(45).build();

        final List<User> users = Arrays.asList(kelvin, joan, ray, troy);

        //save all the users to an empty repo
        if (userRepo.findAll().isEmpty()){
            userRepo.saveAll(users);
        }

        final List<Computer> computers = Arrays.asList(
                Computer.builder().name("MacbookPro").price(1999).users(kelvin).year(2018).modern(false).build(),
                Computer.builder().name("MacbookAir").price(999).users(joan).year(2023).modern(true).build(),
                Computer.builder().name("HPPavilion").price(699).users(ray).year(2013).modern(false).build(),
                Computer.builder().name("MacbookPro").price(2999).users(troy).year(2023).modern(true).build(),
                Computer.builder().name("MiniMac").price(499).users(troy).year(2023).modern(true).build()
        );

        //save the computers to an empty repo.
        if (computerRepo.findAll().isEmpty()){
            computerRepo.saveAll(computers);
        }
//
//        System.out.println("**********************findByName************************");
//        final User userName = userRepo.findByName("Kelvin");
//        System.out.println(userName);

        System.out.println("**********************findByAgeGreaterThan************************");
        final List<User> ageGreaterThan = userRepo.findByAgeGreaterThan(26);
        ageGreaterThan.forEach(System.out::println);

        System.out.println("**********************findByNameAndYear************************");
        final Computer nameAndYear = computerRepo.findByNameAndYear("HP-Pavilion", 2013);
        System.out.println(nameAndYear);

        System.out.println("**********************findByPriceLessThan************************");
        final List<Computer> priceLessThan = computerRepo.findByPriceLessThan(1000);
        priceLessThan.forEach(System.out::println);

        System.out.println("**********************findByPriceGreaterThan************************");
        final List<Computer> priceGreaterThan = computerRepo.findByPriceGreaterThan(1500);
        priceGreaterThan.forEach(System.out::println);

        System.out.println("**********************findByPriceLessThanEqual************************");
        final List<Computer> priceLessThanEqual = computerRepo.findByPriceLessThanEqual(999);
        priceLessThanEqual.forEach(System.out::println);

        System.out.println("**********************findByPriceAndYearGreaterThan************************");
        final List<Computer> priceAndYearGraterThan = computerRepo.findByPriceAndYearGreaterThan(1000, 2018);
        priceAndYearGraterThan.forEach(System.out::println);
        System.out.println("**********************findFirstByModernIsTrue************************");
        final Computer firstModern = computerRepo.findFirstByModernIsTrue();
        System.out.println(firstModern);

        System.out.println("**********************findBottomByModernIsFalse************************");
        final Computer bottomByModern = computerRepo.findBottomByModernIsFalse();
        System.out.println(bottomByModern);

        System.out.println("**********************findByNameIgnoreCase************************");
        final List<Computer> nameIgnoreCase = computerRepo.findByNameIgnoreCase("macbookpro");
        nameIgnoreCase.forEach(System.out::println);

        System.out.println("**********************findTop2ByYear************************");
        final List<Computer> top2ByYear = computerRepo.findTop2ByYear(2019);
        top2ByYear.forEach(System.out::println);

        userRepo.deleteAll();
        computerRepo.deleteAll();

    }
}
