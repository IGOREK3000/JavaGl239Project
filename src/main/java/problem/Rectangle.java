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

    //    double Ax = (double) r.nextInt(50) / 25 - 1;
    //    double Ay = (double) r.nextInt(50) / 25 - 1;
    //    double Cx = (double) r.nextInt(50) / 25 - 1;
    //    double Cy = (double) r.nextInt(50) / 25 - 1;
    //    double angle = r.nextDouble()*Math.PI;
    //    double centerx = (Ax + Cx)/2;
    //    double centery = (Ay + Cy)/2;
    //    double rad = Math.sqrt((Cx-Ax)*(Cx-Ax) + (Cy-Ay)*(Cy-Ay))/2;
    //    double By = 0.5*rad + centery;
    //    double Bx = 0.5*rad + centerx;
    //    double Dy = Ay - (Cy - By);
    //    double Dx = Ax - (Cx - Bx);

            double Ax = (double) r.nextInt(50) / 25 - 1;
            double Ay = (double) r.nextInt(50) / 25 - 1;
            double Bx = (double) r.nextInt(50) / 25 - 1;
            double By = (double) r.nextInt(50) / 25 - 1;
            double Cx = (double) r.nextInt(50) / 25 - 1;
            //double a = Ax-Bx;
            //double b = Ay-By;
            //double c = (Ax*(Bx-Ax)-Ay*(Ay-By));
            //double Cy = -(a*Cx + c)/b;
            //double Dx = Cx + (Ax - Bx);
            //double Dy = Cy + (Ay - By);
        double k = (Bx-Ax)/(Ay-By);
        double b = By - k*Bx;
        double Cy = k*Cx + b;
        double Dx = Cx + (Ax - Bx);
        double Dy = Cy + (Ay - By);
        Vector2 A = new Vector2(Ax, Ay);
        Vector2 B = new Vector2(Bx, By);
        Vector2 C = new Vector2(Cx, Cy);
        Vector2 D = new Vector2(Dx, Dy);
        return new Rectangle(A, B, C, D);
    }
}
