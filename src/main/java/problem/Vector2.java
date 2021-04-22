package problem;

import javax.media.opengl.GL2;

class Vector2 {
    public double x;
    public double y;
    public Vector2() {
        x = 0;
        y = 0;
    }
    public String toString() {
        String s = String.format("(%.2f,%.2f)", x, y);
        return s;
    }
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double rast(Vector2 p1, Vector2 p2) {
        double f = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
        return f;
    }
    public static boolean insideAngle(Vector2 s, Vector2 p1, Vector2 p2, Vector2 p3) {
        boolean f = false;
        if ((Vector2.getAngle(p1, p2, s) < Vector2.getAngle(p1, p2, p3)) && (Vector2.getAngle(p3, p2, s) < Vector2.getAngle(p1, p2, p3))) f = true;
        return f;
    }
    public static Vector2 interectonPoint(Vector2 p1, Vector2 p2, Vector2 p3, Vector2 p4) {
        Vector2 p = new Vector2(0,0);
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

        double a1 = p1.y-p2.y;
        double b1 = p2.x-p1.x;
        double c1 = p1.x*p2.y - p2.x*p1.y;
        double a2 = p3.y-p4.y;
        double b2 = p4.x-p3.x;
        double c2 = p3.x*p4.y - p4.x*p3.y;


        double k1 = (p1.y-p2.y)/(p1.x-p2.x);
        double k2 = (p3.y-p4.y)/(p3.x-p4.x);

        if ((k1 != k2) && (a1*b2-a2*b1 != 0) && (b1*a2-b2*a1 != 0)) {
            p.x = (c2*b1 - c1*b2)/(a1*b2-a2*b1);
            p.y = (c2*a1-c1*a2)/(b1*a2-b2*a1);
        }
        if ((p.x < min1x || p.x < min2x) || (p.y < min1y || p.y < min2y) || (p.x > max1x || p.x > max2x) || (p.y > max1y || p.y > max2y)) {
            p = null;
        }
        if (k1 == k2){
            p = null;
        }

        return p;
    }
    public static double triangleArea(Vector2 p1, Vector2 p2, Vector2 p3) {
        double a = Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
        double b = Math.sqrt((p3.x - p2.x)*(p3.x - p2.x) + (p3.y - p2.y)*(p3.y - p2.y));
        double c = Math.sqrt((p3.x - p1.x)*(p3.x - p1.x) + (p3.y - p1.y)*(p3.y - p1.y));
        double z = (a + b + c)/2;
        double s = Math.sqrt(z*(z-a)*(z-b)*(z-c));
        return s;
    }
    public static double angleOX(Vector2 p1, Vector2 p2) {
        double angle = Math.atan2(p2.x - p1.x, p2.y - p1.y);
        return angle;
    }
    public static double getAngle(Vector2 p1, Vector2 p2, Vector2 p3) {
        double cos = (rast(p1, p2)*rast(p1, p2) + rast(p3, p2)*rast(p3, p2) - rast(p1, p3)*rast(p1, p3))/(2*rast(p1, p2)*rast(p3, p2));
        double angle = Math.abs(Math.acos(cos));
        return angle;
    }

}