package oop2;

abstract public class AbstractPerson {
    protected int year;
    protected String name;
    protected String position;

    protected AbstractPerson(int year, String name, String position) {
        this.year = year;
        this.name = name;
        this.position = position;
    }

    public String value() {
        return String.format("Year:%d, Name:%-10s, Position:%s", this.year, this.name, this.position);
    }

    public void printMe() {
        System.out.println(value());
    }
}