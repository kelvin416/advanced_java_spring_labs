package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepo extends JpaRepository<Computer, Long> {

    Computer findByNameAndYear(String name, Integer year);

    List<Computer> findByPriceLessThan(Integer price);

    List<Computer> findByPriceGreaterThan(Integer price);

    List<Computer> findByPriceLessThanEqual(Integer price);

    List<Computer> findByPriceAndYearGreaterThan(Integer price, Integer year);

    //finds the first modern computer
    Computer findFirstByModernIsTrue();

    //finds the last modern Computer
    Computer findBottomByModernIsFalse();

    List<Computer> findByNameIgnoreCase(String name);

    Computer findByNameAndYearAllIgnoreCase(String name, Integer year);

    List<Computer> findTop2ByYear(Integer year);


}
