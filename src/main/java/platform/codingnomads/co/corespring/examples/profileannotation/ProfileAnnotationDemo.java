package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProfileAnnotationDemo {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(ProfileAnnotationDemo.class);
        final SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        final MachineManagement machineManagement = ctx.getBean(MachineManagement.class);
        System.out.println(machineManagement.testStatus());
        System.out.println("-----------");
        System.out.println(springDeveloper.deployStatus());
        ctx.close();
    }
}
