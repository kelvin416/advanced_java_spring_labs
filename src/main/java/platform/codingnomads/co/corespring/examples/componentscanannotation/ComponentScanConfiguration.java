package platform.codingnomads.co.corespring.examples.componentscanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "platform.codingnomads.co.corespring.examples.componentscanannotation.development")
public class ComponentScanConfiguration {

    @Bean
    public SampleBean sampleBean() {
        return new SampleBean();
    }
}
