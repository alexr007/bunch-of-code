package permut;

public class XPair {
    private final int v1;
    private final int v2;

    public XPair(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int v1() {
        return v1;
    }

    public int v2() {
        return v2;
    }

    @Override
    public String toString() {
        return String.format("XPair{v1=%d, v2=%d}", v1, v2);
    }
}
