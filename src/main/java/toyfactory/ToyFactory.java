package toyfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class ToyFactory {

    @Autowired
    @Qualifier("singletonToy")
    private Toy singletonToy;

    @Autowired
    @Qualifier("prototypeToy1")
    private Toy prototypeToy1;

    @Autowired
    @Qualifier("prototypeToy2")
    private Toy prototypeToy2;

    @Autowired
    @Qualifier("profiledToy")
    private Toy profiledToy;

    @Autowired
    @Qualifier("conditionalToy")
    private Toy conditionalToy;

    @Autowired
    ToyOrderService orderService;

    public void produceToys(){
        System.out.println("\nProducing toys...");

        System.out.println("Singleton Toy ID: " + singletonToy.getId());
        System.out.println("Prototype Toy 1 ID: " + prototypeToy1.getId());
        System.out.println("Prototype Toy 2 ID: " + prototypeToy2.getId());
        System.out.println("Profiled Toy ID: " + profiledToy.getId());
        System.out.println("Conditional Toy ID: " + conditionalToy.getId());

        orderService.orderToy("LegoCastle");
    }
    
    @PreDestroy
    public void onDestroy(){
        prototypeToy1.onDestroy();
        prototypeToy2.onDestroy();
    }
}