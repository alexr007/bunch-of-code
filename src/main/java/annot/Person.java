package annot;


import java.lang.annotation.Documented;

@Ent(author="Alex")
public class Person{
    @Fi(key=true)
    private final int id;
    @Fi
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Me
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "id:"+id+", name:"+name;
    }
}
