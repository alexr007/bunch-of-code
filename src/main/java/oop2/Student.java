package oop2;

public class Student extends AbstractPerson implements Doable{
    protected Student(int year, CharSequence name) {
        this(year, name, "Student");
    }

    private Student(int year, CharSequence name, String position) {
        super(year, name.toString(), position);
    }

    static Student build(int year, String name) {
        return new Student(year, name);
    }

    @Override
    public void doIt() {
        System.out.println("I'm student");
    }
}
