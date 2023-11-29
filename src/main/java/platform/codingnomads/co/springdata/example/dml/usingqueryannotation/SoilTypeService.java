package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.Plant;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import java.util.ArrayList;


@Service
public class SoilTypeService {

    @Autowired
    SoilTypeRepo soilTypeRepo;

    @Transactional
    public  void saveSoilTypes(){
        if (soilTypeRepo.findAll().isEmpty()){
            SoilType soilType1 = SoilType.builder().name("Clay").ph(7.6).dry(false).build();
            soilTypeRepo.save(soilType1);

            SoilType soilType2 = SoilType.builder().name("Loam").ph(5.5).dry(false).build();
            soilTypeRepo.save(soilType2);

            SoilType soilType3 = SoilType.builder().name("Sand").ph(7.7).dry(false).build();
            soilTypeRepo.save(soilType3);

            SoilType soilType4 = SoilType.builder().name("Silt").ph(7.9).dry(true).build();
            soilTypeRepo.save(soilType4);

            SoilType soilType5 = SoilType.builder().name("Aridisol").ph(6.6).dry(true).build();
            soilTypeRepo.save(soilType5);

            SoilType soilType6 = SoilType.builder().name("Andisol").ph(4.4).dry(false).build();
            soilTypeRepo.save(soilType6);

            SoilType soilType7 = SoilType.builder().name("White Sand").ph(7.1).dry(true).build();
            soilTypeRepo.save(soilType7);

            SoilType soilType8 = SoilType.builder().name("Red Loam").ph(4.4).dry(true).build();
            soilTypeRepo.save(soilType8);

            SoilType soilType9 = SoilType.builder().name("Red Clay").ph(7.5).dry(true).build();
            soilTypeRepo.save(soilType9);

            SoilType soilType10 = SoilType.builder().name("Red Soil").ph(3.6).dry(false).build();
            soilTypeRepo.save(soilType10);
        }
    }

    @Transactional
    public void getSoilTypes(){
        System.out.println("NAMES OF AVAILABLE SOIL TYPES..");

        ArrayList<SoilType> soilTypesAvailable = soilTypeRepo.getSoilType();

        for (SoilType st : soilTypesAvailable) {
            System.out.println(st.toString());
        }

        System.out.println("---------SOIL TYPE PH------------");
        ArrayList<SoilType> soilTypesPh = soilTypeRepo.getSoilTypeByPhRange(4.4, 7.1);
        soilTypesPh.forEach(System.out::println);

        //Setting up a page request
        Pageable pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("soilTypePh")));
        Page<SoilType> page;

        do {
            page = soilTypeRepo.getSoilTypesWithPhLessThan(7, pageRequest);

            System.out.println("PAGE" + (page.getNumber() + 1));

            //printing the contents of the current page
            page.getContent().forEach(System.out::println);

            //get the next page
            pageRequest = pageRequest.next();

        } while (page.hasNext());
    }
}
