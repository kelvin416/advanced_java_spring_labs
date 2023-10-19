package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AlienApp {
    @Value("${allien.name}")
    private String alienName;

    @Value("${allien.age}")
    private Integer alienAge;

    public String getAlienName() {
        return alienName;
    }

    public Integer getAlienAge() {
        return alienAge;
    }
}
