package duck;

public class Duck implements Walkable {
    @Override
    public void walk() {
        System.out.println("I'm walking!");
    }

    public void think() {
        System.out.println("I'm thinking!");
    }
}
