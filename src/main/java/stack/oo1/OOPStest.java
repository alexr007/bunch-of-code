package stack.oo1;

public class OOPStest {
    public static void main(String[] args)  {
        OOPS oops = new OOPS(new DataGen());
        String q;
        String format="Query:%s, Response:%s\n";
        try {
            q = "Developer";
            System.out.printf(format, q, oops.salary(q));
            q = "Manager";
            System.out.printf(format, q, oops.salary(q));
            q = "Teacher";
            System.out.printf(format, q, oops.salary(q));
        } catch (Exception e) {
            System.out.println("not found");
        }
    }
}
