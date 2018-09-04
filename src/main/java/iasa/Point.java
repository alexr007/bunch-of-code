package iasa;

public class Point implements Behavior2 {
    private  int x;
    private  int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String value() {
        //return "x="+this.x+",y="+this.y;
        return String.format("x=%d, y=%d",this.x,this.y);
    }

    @Override
    public Point move(int deltaX, int deltaY) {
        return new Point(this.x+deltaX, this.y+deltaY);
    }

    public void move2(int deltaX, int deltaY) {
        this.x+=deltaX;
        this.y+=deltaY;
    }
}
