package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Rectangle {
    Vector2 A;
    Vector2 B;
    Vector2 C;
    Vector2 D;

    public Rectangle(Vector2 A, Vector2 B, Vector2 C, Vector2 D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public void render(GL2 gl) {
        gl.glPointSize(1);
        gl.glBegin(GL2.GL_LINE_STRIP);
        gl.glVertex2d(A.x, A.y);
        gl.glVertex2d(B.x, B.y);
        gl.glVertex2d(C.x, C.y);
        gl.glVertex2d(D.x, D.y);
        gl.glVertex2d(A.x, A.y);

        gl.glEnd();
    }

    public static Rectangle randomRectangle() {
        Random r = new Random();

        double Ax = (double) r.nextInt(50) / 25 - 1;
        double Ay = (double) r.nextInt(50) / 25 - 1;
        double Bx = (double) r.nextInt(50) / 25 - 1;
        double By = (double) r.nextInt(50) / 25 - 1;
        double Cx = (double) r.nextInt(50) / 25 - 1;
        double k = (Bx - Ax) / (Ay - By);
        double b = By - k * Bx;
        double Cy = k * Cx + b;
        double Dx = Cx + (Ax - Bx);
        double Dy = Cy + (Ay - By);
        Vector2 A = new Vector2(Ax, Ay);
        Vector2 B = new Vector2(Bx, By);
        Vector2 C = new Vector2(Cx, Cy);
        Vector2 D = new Vector2(Dx, Dy);
        return new Rectangle(A, B, C, D);
    }
    public static Vector2 insidePoint(Vector2 v, Rectangle r) {
        Vector2 f = new Vector2();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        if ((Vector2.interectonPoint(v, r.A, r.B, r.C).x == 100) && ((Vector2.interectonPoint(v, r.A, r.C, r.D).x == 100))) a = 1;
        if ((Vector2.interectonPoint(v, r.B, r.A, r.C).x == 100) && ((Vector2.interectonPoint(v, r.B, r.C, r.D).x == 100))) b = 1;
        if ((Vector2.interectonPoint(v, r.C, r.A, r.B).x == 100) && ((Vector2.interectonPoint(v, r.C, r.A, r.D).x == 100))) c = 1;
        if ((Vector2.interectonPoint(v, r.D, r.B, r.C).x == 100) && ((Vector2.interectonPoint(v, r.D, r.A, r.C).x == 100))) d = 1;
        if ((a == 1) && (b == 1) && (c == 1) && (d == 1)) {
            f.x = v.x;
            f.y = v.y;
        } else {
            f.x = 100;
            f.y = 100;
        }
        return f;
    }
}
