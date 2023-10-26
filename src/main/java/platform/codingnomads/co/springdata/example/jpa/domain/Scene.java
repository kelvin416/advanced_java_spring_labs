package platform.codingnomads.co.springdata.example.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "Scenes")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "latitude")
    private int lat;

    @Column(name = "longitude")
    private int lon;

    private String name;
}
