package toyfactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToyFactoryRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ToyFactory factory = context.getBean(ToyFactory.class);
        
        factory.produceToys();

        context.close();
    }
}