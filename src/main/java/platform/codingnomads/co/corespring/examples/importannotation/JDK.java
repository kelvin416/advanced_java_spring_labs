package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDK {

    @Bean
    public SpringDeveloper springDeveloper(){
        return new SpringDeveloper();
    }
}
