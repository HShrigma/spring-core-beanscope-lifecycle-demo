package toyfactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Toy {
    static int counter = 0;
    private int id;

    public Toy() {
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    @PostConstruct
    public void onCreate() {
        System.out.printf("[LOG] [TOY CREATED] ID: %d\n", id);
    }
    @PreDestroy
    public void onDestroy() {
        System.out.printf("[LOG] [TOY DESTROYED] ID: %d\n", id);
    }
}