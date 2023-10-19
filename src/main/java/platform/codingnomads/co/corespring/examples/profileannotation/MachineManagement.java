package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "application-test.properties", ignoreResourceNotFound = true)
public class MachineManagement {

    @Value("${test.activity}")
    private String testActivity;

    @Value("${test.version}")
    private String testVersion;

    public MachineManagement(){
        System.out.println("Ready to learn machine management....");
    }

    public String testStatus(){
        return testActivity.concat(" server of version: ").concat(testVersion);
    }
}
