package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.Random;

/**
 * Класс точки
 */
public class Point {
    /**
     * константа множества 1
     */
    public static final int SET_1 = 0;
    /**
     * константа множества 2
     */
    public static final int SET_2 = 1;
    /**
     * номер множества
     */
    int setNumber;
    /**
     * пересекается ли точка с точкой из другого множества
     * (является ли она решением)
     */
    boolean isSolution = false;
    /**
     * x - координата точки
     */
    double x;
    /**
     * y - координата точки
     */
    double y;

    /**
     * Конструктор точки
     *
     * @param x         координата
     * @param y         координата y
     * @param setNumber номер множества, к которому принадлежит точка
     */
    Point(double x, double y, int setNumber) {
        this.x = x;
        this.y = y;
        this.setNumber = setNumber;
    }

    /**
     * Получить случайную точку
     *
     * @return случайная точка
     */


    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     */
    void render(GL2 gl) {
        if (isSolution)
            gl.glColor3d(1.0, 0.0, 0.0);
        else
            switch (setNumber) {
                case Point.SET_1:
                    gl.glColor3d(0.0, 1.0, 0.0);
                    break;
                case Point.SET_2:
                    gl.glColor3d(0.0, 0.0, 1.0);
                    break;
            }
        gl.glPointSize(3);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glEnd();
        gl.glPointSize(1);
    }

    public static Point interectonPoint(Point p1, Point p2, Point p3, Point p4) {
        Point p = new Point();
        double sin1 = (p1.y - p2.y)/Math.sqrt((p1.y - p2.y)*(p1.y - p2.y) + (p1.x - p2.x)*(p1.x - p2.x));
        double sin2 = (p3.y - p4.y)/Math.sqrt((p3.y - p4.y)*(p3.y - p4.y) + (p3.x - p4.x)*(p3.x - p4.x));
        double k1 = Math.abs(sin1);
        double k2 = Math.abs(sin2);
        if (k1 != k2) {
            p.x = ((p3.x * p4.y - p4.x * p3.y)*(p2.x - p1.x) - (p1.x * p2.y - p2.x * p1.y)*(p4.x - p3.x))/(p1.y - p2.y)*(p4.x - p3.x)-(p3.y - p4.y)*(p2.x - p1.x));
            p.y = ((p3.x * p4.y - p4.x * p3.y)*(p1.y - p2.y)-(p1.x * p2.y - p2.x * p1.y)*(p3.y - p4.y))/((p2.x - p1.x)*(p3.y - p4.y)-(p4.x - p3.x)*(p1.y - p2.y));
        }
        if (k1 == k2){
            p = null;
        }
        int min1x;
        int min1y;
        int min2x;
        int min2y;
        int max1x;
        int max1y;
        int max2x;
        int max2y;

        if (p1.x >= p2.x) {
            max1x = p1.x;
            min1x = p2.x;
        } else {
            max1x = p2.x;
            min1x = p1.x;
        }
        if (p.x )
    }

    /**
     * Получить строковое представление точки
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "Точка с координатами: {" + x + "," + y + "} из множества: " + setNumber;
    }
}
