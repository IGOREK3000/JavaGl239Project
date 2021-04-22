package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Rectangle> rectangles;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        rectangles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки

     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
// Rectangle point = new Point(x, y, setVal);
// rectangles.add(point);
    }

    /**
     * Решить задачу
     */
    Vector2 Area[] = new Vector2[7];
    Vector2 m = new Vector2(0,0);
    Rectangle Rect1 = new Rectangle(m, m, m, m);
    Rectangle Rect2 = new Rectangle(m, m, m, m);
    Vector2 middle = new Vector2(0,0);
    int length = 0;

    public void solve() {
        int g1 = 0;
        int g2 = 0;
        double maxS = 0;
// перебираем пары прямоугольников
        for (Rectangle r1 : rectangles) {
            g1++;
            g2 = 0;
            System.out.println("/////////////////");
            for (Rectangle r2 : rectangles) {
                g2++;
                if ((g1 != g2) && (Vector2.rast(r1.A, r1.B) >= 0.001) && (Vector2.rast(r2.A, r2.D) >= 0.001) && (Vector2.rast(r1.A, r1.D) >= 0.001) && (Vector2.rast(r2.A, r2.B) >= 0.001)) {
                    Vector2 p1 = Vector2.interectonPoint(r1.A, r1.B, r2.A, r2.B);
                    Vector2 p2 = Vector2.interectonPoint(r1.B, r1.C, r2.A, r2.B);
                    Vector2 p3 = Vector2.interectonPoint(r1.C, r1.D, r2.A, r2.B);
                    Vector2 p4 = Vector2.interectonPoint(r1.A, r1.D, r2.A, r2.B);
                    Vector2 p5 = Vector2.interectonPoint(r1.A, r1.B, r2.B, r2.C);
                    Vector2 p6 = Vector2.interectonPoint(r1.B, r1.C, r2.B, r2.C);
                    Vector2 p7 = Vector2.interectonPoint(r1.C, r1.D, r2.B, r2.C);
                    Vector2 p8 = Vector2.interectonPoint(r1.A, r1.D, r2.B, r2.C);
                    Vector2 p9 = Vector2.interectonPoint(r1.A, r1.B, r2.C, r2.D);
                    Vector2 p10 = Vector2.interectonPoint(r1.B, r1.C, r2.C, r2.D);
                    Vector2 p11 = Vector2.interectonPoint(r1.C, r1.D, r2.C, r2.D);
                    Vector2 p12 = Vector2.interectonPoint(r1.A, r1.D, r2.C, r2.D);
                    Vector2 p13 = Vector2.interectonPoint(r1.A, r1.B, r2.A, r2.D);
                    Vector2 p14 = Vector2.interectonPoint(r1.B, r1.C, r2.A, r2.D);
                    Vector2 p15 = Vector2.interectonPoint(r1.C, r1.D, r2.A, r2.D);
                    Vector2 p16 = Vector2.interectonPoint(r1.A, r1.D, r2.A, r2.D);
                    Vector2 p17 = Rectangle.insidePoint(r1.A, r2);
                    Vector2 p18 = Rectangle.insidePoint(r1.B, r2);
                    Vector2 p19 = Rectangle.insidePoint(r1.C, r2);
                    Vector2 p20 = Rectangle.insidePoint(r1.D, r2);
                    Vector2 p21 = Rectangle.insidePoint(r2.A, r1);
                    Vector2 p22 = Rectangle.insidePoint(r2.B, r1);
                    Vector2 p23 = Rectangle.insidePoint(r2.C, r1);
                    Vector2 p24 = Rectangle.insidePoint(r2.D, r1);

                    Vector2[] points = new Vector2[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24};


                    Vector2 polygon[] = new Vector2[]{null, null, null, null, null, null, null};
                    int l1 = 0;
                    for (int i = 0; i < 24; i++) {
                        System.out.println(points[i]);
                        if (points[i] != null) {
                            polygon[l1] = points[i];
                            l1++;
                        }
                    }
                    if (l1 <= 2) {
                        polygon[0] = null;
                        polygon[1] = null;
                    }
                    double sumx = 0;
                    double sumy = 0;
                    int sumxy = 0;
                    for (int i = 0; i <= 6; i++) {
                        if (polygon[i] != null) {
                            sumx = sumx + polygon[i].x;
                            sumy = sumy + polygon[i].y;
                            sumxy++;
                        }
                    }
                    Vector2 sr = new Vector2();
                    sr.x = sumx / sumxy;
                    sr.y = sumy / sumxy;
                    Vector2 min = new Vector2(0,0);
                    double minangle = Math.PI;
                    int min_i = 0;
                    for (int i = 0; i < sumxy; i++) {
                        minangle = Vector2.angleOX(sr, polygon[i]);
                        min_i = i;
                        for (int j = i + 1; j < sumxy; j++)
                            if (Vector2.angleOX(sr, polygon[j]) < minangle) {
                                minangle = Vector2.angleOX(sr, polygon[j]);
                                min_i = j;
                            }
                        if (min_i != i) {
                            Vector2 tm = new Vector2(polygon[i].x, polygon[i].y);
                            polygon[i].x = polygon[min_i].x;
                            polygon[i].y = polygon[min_i].y;
                            polygon[min_i] = tm;
                        }
                    }
                    double S1 = 0;
                    for (int i = 0; i < sumxy - 1; i++) {
                        S1 = S1 + Vector2.triangleArea(sr, polygon[i], polygon[i + 1]);
                    }
                    double S = 0;
                    if (sumxy != 0) S = S1 + Vector2.triangleArea(sr, polygon[sumxy - 1], polygon[0]);
                    if (g1 == g2) S = 0;
                    if (S > maxS) {
                        maxS = S;
                        length = sumxy;
                        middle.x = sr.x;
                        middle.y = sr.y;
                        Rect1 = r1;
                        Rect2 = r2;
                        for (int i = 0; i < sumxy; i++) {
                            Area[i] = polygon[i];
                        }
                    }
                }
            }

        }




    }
// если точки являются разными
// if (p != p2) {
// // если координаты у них совпадают
// if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
// p.isSolution = true;
// p2.isSolution = true;
// }
// }
// }
// }


    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        rectangles.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);


// пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x1 = sc.nextDouble();
                double y1 = sc.nextDouble();
                double x2 = sc.nextDouble();
                double y2 = sc.nextDouble();
                double x3 = sc.nextDouble();
                double y3 = sc.nextDouble();
                double x4 = sc.nextDouble();
                double y4 = sc.nextDouble();
                Vector2 A = new Vector2(x1, y1);
                Vector2 B = new Vector2(x2, y2);
                Vector2 C = new Vector2(x3, y3);
                Vector2 D = new Vector2(x4, y4);
                sc.nextLine();
                Rectangle rect = new Rectangle(A, B, C, D);
                rectangles.add(rect);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Rectangle rect : rectangles) {
                out.printf("%.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f\n", rect.A.x, rect.A.y, rect.B.x, rect.B.y, rect.C.x, rect.C.y, rect.D.x, rect.D.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomRectangles(int n) {
        rectangles.clear();
        for (int i = 0; i < n; i++) {
            rectangles.add(Rectangle.randomRectangle());
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        rectangles.clear();
        length = 0;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */

    public void render(GL2 gl) {

        for (Rectangle point : rectangles) {
            point.render(gl);
        }
        if (length >= 3) {

            for (int i = 0; i < length - 1; i++) {
                Figures.renderTriangle(gl, middle, Area[i], Area[i + 1], true);
            }
            Figures.renderTriangle(gl, middle, Area[0], Area[length - 1], true);
            gl.glColor3f(1, 0, 0);
            Rect1.render(gl);
            Rect2.render(gl);
            gl.glColor3f(1, 1, 1);
        }



    }
}