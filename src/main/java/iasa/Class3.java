package iasa;

public class Class3 {
    private int x;

    public Class3(int x) {
        this.x = x;
    }

    public void add(int a) {
        this.x+=a;
    }

    public int getX() {
        return this.x;
    }

    public String getXs() {
        return "x="+Integer.toString(this.x);
    }
}
