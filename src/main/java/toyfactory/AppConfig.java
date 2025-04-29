package toyfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Toy singletonToy() {
        return new Toy();
    }

    @Bean
    @Scope("prototype")
    public Toy prototypeToy1() {
        return new Toy();
    }

    @Bean
    @Scope("prototype")
    public Toy prototypeToy2() {
        return new Toy();
    }

    @Bean
    public ToyFactory toyFactory(){
        return new ToyFactory();
    }
}