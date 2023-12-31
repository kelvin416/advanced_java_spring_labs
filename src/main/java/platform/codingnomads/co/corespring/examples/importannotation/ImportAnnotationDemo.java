package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportAnnotationConfig.class);
        ctx.refresh();
        final Framework framework = ctx.getBean(Framework.class);
        final SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        ctx.close();
    }
}
