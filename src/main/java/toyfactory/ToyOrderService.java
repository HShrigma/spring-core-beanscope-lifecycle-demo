package toyfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ToyOrderService {

    @Autowired
    ApplicationEventPublisher publisher;

    public void orderToy(String name){
        System.out.println("[ORDER] Toy ordered: " + name);
        publisher.publishEvent(new ToyOrderEvent(name));
    }
}