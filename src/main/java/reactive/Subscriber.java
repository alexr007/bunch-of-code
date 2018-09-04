package reactive;

public class Subscriber {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void subscribe(Producer p) {
        p.addSubscriber(this);
    }

    public void unSubscribe(Producer p) {
        p.removeSubscriber(this);
    }

    public void newEvent(String event) {
        System.out.printf("I'm %s.", name);
        System.out.printf("GOT new Event: %s\n", event);
    }
}
