package problem;

class Vector2 {
    public double x;
    public double y;
    public Vector2() {
        x = 1;
        y = 0;
    }
    public String toString() {
        String s = String.format("(%.2f,%.2f)", x, y);
        return s;
    }
    public Vector2(double x, double y) {
        this.x =x ;
        this.y = y;
    }
    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double len() {
        return Math.sqrt(x*x + y*y);
    }
    public void x(double k) {
        this.x = x * k;
        this.y = y * k;
    }
    public void plus(Vector2 v) {
        this.x = x + v.x;
        this.y = y + v.y;
    }
    public void minus(Vector2 v) {
        this.x = x - v.x;
        this.y = y - v.y;
    }
    public Vector2 sum(Vector2 v) {
        Vector2 l = new Vector2(0,0);
        l.x = x + v.x;
        l.y = y + v.y;
        return l;
    }
    public static Vector2 sum(Vector2 m, Vector2 n) {
        Vector2 l = new Vector2(0,0);
        l.x = m.x + n.x;
        l.y = m.y + n.y;
        return l;
    }
    public Vector2 mult(double k) {
        Vector2 l = new Vector2(0,0);
        l.x = x * k;
        l.y = y * k;
        return l;
    }
    public double mult(Vector2 v) {
        return v.x*x + v.y*y;
    }
    public static double mult(Vector2 m, Vector2 n) {
        return m.x*n.x + m.y*n.y;
    }
    public static Vector2 mult(Vector2 m, double n) {
        Vector2 l = new Vector2(0,0);
        l.x = m.x * n;
        l.y = m.y * n;
        return l;
    }

}