package toyfactory;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ToyFactoryRunnerTest {

    @Test
    public void testToysAreCreatedWithCorrectScopes() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Toy singleton1 = context.getBean("singletonToy", Toy.class);
        Toy singleton2 = context.getBean("singletonToy", Toy.class);

        Toy prototype1 = context.getBean("prototypeToy1", Toy.class);
        Toy prototype2 = context.getBean("prototypeToy2", Toy.class);

        // Singleton toys should be same instance
        assertSame(singleton1, singleton2);

        // Prototype toys should be different instances
        assertNotEquals(prototype1.getId(), prototype2.getId());

        context.close();
    }
}
