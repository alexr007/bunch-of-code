package observer;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private int eventId = 0;

    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    public void newEvent() {
        String event = String.format("Event #%d", ++eventId);
        System.out.printf("Generating event %s\n", event);
        System.out.printf("Sending event to subscribers\n");
        subscribers.forEach(s->s.newEvent(event));
    }
}
