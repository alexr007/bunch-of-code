package danit.fs2;

public class Append {
    public static void main(String[] args) {
        String s1= "  q";
        String s2= "  a";
        String s3= "  b";
        String s4= "  z";
        String s = new StringBuilder().append(s1)
                .append(s2)
                .append(s3.trim())
                .append(s4).toString();

    }
}
