package platform.codingnomads.co.ioc.examples.dependencylookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringFrameWorkDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFrameWorkDemoApplication.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(IOCDemoConfiguration.class);
        GreetingRenderer greetingRenderer = ctx.getBean("renderer", GreetingRenderer.class);
        greetingRenderer.render();

        GoodMorning goodMorning = ctx.getBean(GoodMorning.class);
        greetingRenderer.setGreetingProvider(goodMorning);
        greetingRenderer.render();
    }
}
