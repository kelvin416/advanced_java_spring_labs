package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.text.MessageFormat;

@Configuration
@ImportResource({"classpath*:xml-config/movies.xml"})
public class MoviesConfig {

    @Bean
    public Animation animation(){
        return new Animation("Django", 2016);
    }

}
