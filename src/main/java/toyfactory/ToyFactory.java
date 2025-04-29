package toyfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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

    public void produceToys(){
        System.out.println("\nProducing toys...");

        System.out.println("Singleton Toy ID: " + singletonToy.getId());
        System.out.println("Prototype Toy 1 ID: " + prototypeToy1.getId());
        System.out.println("Prototype Toy 2 ID: " + prototypeToy2.getId());
    }
}