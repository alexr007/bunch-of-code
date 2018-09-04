package codegym;

public class T1 {
    public static void main(String[] args) {
        String b = "sdfgh";
        byte st = 1;
        byte en = 4;
        byte[] by = new byte[en - st];
        b.getBytes(st, en, by, 0);
        System.out.println(by+" ");
    }
}
