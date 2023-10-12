package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;
    private Integer population;

    public Country(String name, Integer population) {
        this.name = name;
        this.population = population;
    }
}
