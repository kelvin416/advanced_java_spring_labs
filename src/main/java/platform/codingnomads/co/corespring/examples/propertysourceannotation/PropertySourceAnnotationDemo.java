package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceAnnotationConfig.class);
        ctx.refresh();
        final App app = ctx.getBean(App.class);
        final AlienApp alienApp = ctx.getBean(AlienApp.class);
        System.out.println("-------");
//        System.out.println("Values from myapp.properties: " +
//                "App Name: " + app.getAppName() + ", App Version: " + app.getAppVersion());

        System.out.println("Values from allienapp.properties: " +
                "Alien Name is: " + alienApp.getAlienName() + ", Alien age is: " + alienApp.getAlienAge());
        ctx.close();
    }
}
