package toyfactory;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ToyOrderListener {

    @EventListener
    public void onToyOrderedHandler(ToyOrderEvent event){
        System.out.println("[EVENT LISTENER] Handling toy order: " + event.getToyName());
    }
}