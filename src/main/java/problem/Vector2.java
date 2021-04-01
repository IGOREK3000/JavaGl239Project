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

    public static Vector2 interectonPoint(Vector2 p1, Vector2 p2, Vector2 p3, Vector2 p4) {
        Vector2 p = new Vector2();
        double sin1 = (p1.y - p2.y)/Math.sqrt((p1.y - p2.y)*(p1.y - p2.y) + (p1.x - p2.x)*(p1.x - p2.x));
        double sin2 = (p3.y - p4.y)/Math.sqrt((p3.y - p4.y)*(p3.y - p4.y) + (p3.x - p4.x)*(p3.x - p4.x));
        double k1 = Math.abs(sin1);
        double k2 = Math.abs(sin2);
        if (k1 != k2) {
            p.x = ((p3.x * p4.y - p4.x * p3.y)*(p2.x - p1.x) - (p1.x * p2.y - p2.x * p1.y)*(p4.x - p3.x))/(p1.y - p2.y)*(p4.x - p3.x)-(p3.y - p4.y)*(p2.x - p1.x));
            p.y = ((p3.x * p4.y - p4.x * p3.y)*(p1.y - p2.y)-(p1.x * p2.y - p2.x * p1.y)*(p3.y - p4.y))/((p2.x - p1.x)*(p3.y - p4.y)-(p4.x - p3.x)*(p1.y - p2.y));
        }
        if (k1 == k2){
            p.x = 100;
            p.y = 100;
        }
        double min1x;
        double min1y;
        double min2x;
        double min2y;
        double max1x;
        double max1y;
        double max2x;
        double max2y;

        if (p1.x >= p2.x) {
            max1x = p1.x;
            min1x = p2.x;
        } else {
            max1x = p2.x;
            min1x = p1.x;
        }
        if (p1.y >= p2.y) {
            max1y = p1.y;
            min1y = p2.y;
        } else {
            max1y = p2.y;
            min1y = p1.y;
        }
        if (p3.x >= p4.x) {
            max2x = p3.x;
            min2x = p4.x;
        } else {
            max2x = p4.x;
            min2x = p3.x;
        }
        if (p3.y >= p4.y) {
            max2y = p3.y;
            min2y = p4.y;
        } else {
            max2y = p4.y;
            min2y = p3.y;
        }

        if (p.x < min1x || p.x > max1x || p.y > max1y || p.y < min1y || p.x < min2x || p.x > max2x || p.y > max2y || p.y < min2y) {
            p.x = 100;
            p.x = 100;
        }
        return p;
    }
}