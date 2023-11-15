package platform.codingnomads.co.springdata.example.ddl.manytomany.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class MobilePhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String phoneName;

    @JoinColumn(name = "names_id")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PhoneBook> phoneBooks;
}
