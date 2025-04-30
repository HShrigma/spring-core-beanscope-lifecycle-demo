package toyfactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("toyfactory")
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
    @Profile("dev")
    @Qualifier("profiledToy")
    public Toy devToy() {
        System.out.println("[PROFILED BEAN] Loaded Dev Toy");
        return new Toy();
    }

    @Bean
    @Profile("prod")
    @Qualifier("profiledToy")
    public Toy prodToy() {
        System.out.println("[PROFILED BEAN] Loaded Prod Toy");
        return new Toy();
    }
    @Bean
    public ToyFactory toyFactory(){
        return new ToyFactory();
    }
}