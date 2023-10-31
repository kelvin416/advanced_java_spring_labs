package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tires")
@NoArgsConstructor
@Setter
@Getter
public class Tires {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tyre", nullable = false)
    private String tyreType;

    @OneToOne
    private Car car;
}
