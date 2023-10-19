package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "application-deploy.properties", ignoreResourceNotFound = true)
public class SpringDeveloper {

    @Value("${deploy.activity}")
    private String deployActivity;
    @Value("${deploy.version}")
    private String deployVersion;
    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }

    @Bean
    public String deployStatus(){
        return deployActivity.concat(" application of version: ").concat(deployVersion);
    }
}
