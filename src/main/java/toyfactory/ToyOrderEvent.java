package toyfactory;

public class ToyOrderEvent {
    private final String toyName;

    public ToyOrderEvent(String toyName){
        this.toyName = toyName;
    }

    public String getToyName(){
        return toyName;
    }
}