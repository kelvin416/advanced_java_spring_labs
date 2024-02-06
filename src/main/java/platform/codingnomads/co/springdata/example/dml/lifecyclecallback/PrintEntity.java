package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here

    @PrePersist
    private void saveDataStructures(){
        System.out.println("Save Some Data Structures");
    }

    @PostUpdate
    private void getSomeJava(){
        System.out.println("Get Some Java Projects Done..");
    }

    @PostLoad
    private void loadGoLangProject(){
        System.out.println("Load Go projects");
    }

}
