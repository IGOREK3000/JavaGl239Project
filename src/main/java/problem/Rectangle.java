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
        double cos = (double) r.nextInt(31415) / 10000 - 1.5;
        double sin = cos;
        double centerx = (Ax + Bx)/2;
        double centery = (Ay + By)/2;
        double Cy = Math.sin(sin) + centery;
        double Cx = Math.cos(cos) + centerx;
        double Dy = Cy - (By - Cy);
        double Dx = Cx - (Bx - Cx);
        Vector2 A = new Vector2(Ax, Ay);
        Vector2 B = new Vector2(Bx, By);
        Vector2 C = new Vector2(Cx, Cy);
        Vector2 D = new Vector2(Dx, Dy);
        return new Rectangle(A, B, C, D);
    }
}
