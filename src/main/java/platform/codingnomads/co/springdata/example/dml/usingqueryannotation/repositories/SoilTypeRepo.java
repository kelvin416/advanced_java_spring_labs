package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.Plant;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.ArrayList;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    @Query("SELECT st FROM SoilType st")
    ArrayList<SoilType> getSoilType();

    @Query("SELECT st FROM SoilType st WHERE ph > ?1 AND ph < ?2")
    ArrayList<SoilType> getSoilTypeByPhRange(double minPh, double maxPh);

    //boolean dry
    @Query("SELECT st FROM SoilType st WHERE dry = ?1")
    ArrayList<SoilType> getSoilTypeBasedOnDryness (boolean dry);
    //Long id
    @Query("SELECT st FROM SoilType st WHERE id = ?1")
    SoilType getSoilTypeById(Long id);

    //name
    @Query("SELECT st FROM SoilType st WHERE name = :soilTypeName")
    ArrayList<SoilType> getSoilTypeByName(@Param("soilTypeName") String soilTypeName);

    //Pageable query

    @Query(
            value = "SELECT st FROM SoilType st WHERE ph < ?1",
            countQuery = "SELECT count(st) FROM SoilType st WHERE ph < ?1 "
    )
    Page<SoilType> getSoilTypesWithPhLessThan(double phHigher, Pageable pageable);
}
