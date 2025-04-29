package toyfactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

public class ToyFactoryRunner {

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Get env manually
        ConfigurableEnvironment env = context.getEnvironment();
        env.getPropertySources().addLast(
            new ResourcePropertySource("classpath:application.properties")
        );

        // Register config & refresh
        context.register(AppConfig.class);
        context.refresh();

        // execute main bean method
        ToyFactory factory = context.getBean(ToyFactory.class);
        factory.produceToys();

        context.close();
    }
}