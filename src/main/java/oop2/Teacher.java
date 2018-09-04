package oop2;

public class Teacher extends AbstractPerson implements Doable {
    protected Teacher(int year, String name) {
        this(year, name, "Teacher");
    }

    private Teacher(int year, String name, String position) {
        super(year, name, position);
    }

    @Override
    public void doIt() {
        System.out.println("I'm teacher");
    }
}
