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
     * @param x      координата X точки
     * @param y      координата Y точки
     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
//        Rectangle point = new Point(x, y, setVal);
//        rectangles.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары прямоугольников
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        int f4 = 0;
        double s = 0;
        Vector2[] triangle1 = new Vector2[2];
        Vector2[] triangle2 = new Vector2[2];
        Vector2[] triangle3 = new Vector2[2];
        Vector2[] triangle4 = new Vector2[2];
        for (Rectangle r1 : rectangles) {
            for (Rectangle r2 : rectangles) {
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
                Vector2[] points = new Vector2[] {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16};


                int t = 1;
                for (int i = 1; i < 16; i++) {
                    int k1 = 0;
                    if ((points[i].x != 100) && (k1 < 3)) {
                        k1++;
                        triangle1[k1 - 1] = points[i];
                        t = i;
                        f1 = 1;
                    }
                }

                int t1 = 15;
                for (int i = t+1; i < 16; i++) {
                    int k2 = 0;
                    if ((points[i].x != 100) && (k2 < 1)) {
                        if (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], triangle1[2]).x != 100) {
                            triangle2[0] = triangle1[1];
                            triangle2[1] = triangle1[2];
                            triangle2[2] = points[i];
                        }
                        if (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], triangle1[2]).x != 100) {
                            triangle2[0] = triangle1[0];
                            triangle2[1] = triangle1[2];
                            triangle2[2] = points[i];
                        }
                        if (Vector2.interectonPoint(points[i], triangle1[2], triangle1[0], triangle1[1]).x != 100) {
                            triangle2[0] = triangle1[0];
                            triangle2[1] = triangle1[1];
                            triangle2[2] = points[i];
                        }
                        f2 = 1;
                        t1 = i;
                        k2++;
                    }
                }

                int t2 = 15;
                for (int i = t1+1; i < 16; i++) {
                    int k3 = 0;
                    int v0 = 0;
                    int v1 = 0;
                    int v2 = 0;
                    int v3 = 0;
                    if ((points[i].x != 100) && (k3 < 1)) {
                        if ((Vector2.interectonPoint(points[i], triangle1[0], triangle1[2], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], triangle1[2]).x == 100)) v0 = 1;
                        if ((Vector2.interectonPoint(points[i], triangle1[1], triangle1[2], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], triangle1[2]).x == 100)) v1 = 1;
                        if ((Vector2.interectonPoint(points[i], triangle1[2], triangle1[0], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[1], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[1], triangle1[0]).x == 100)) v2 = 1;
                        if ((Vector2.interectonPoint(points[i], points[t1], triangle1[0], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[2], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[2], triangle1[0]).x == 100)) v3 = 1;
                        if ((v0 == 1) && (v1 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = triangle1[0];
                            triangle3[2] = triangle1[1];
                        }
                        if ((v1 == 1) && (v2 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = triangle1[1];
                            triangle3[2] = triangle1[2];
                        }
                        if ((v2 == 1) && (v3 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = triangle1[2];
                            triangle3[2] = points[t1];
                        }
                        if ((v3 == 1) && (v0 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = points[t1];
                            triangle3[2] = triangle1[0];
                        }
                        if ((v1 == 1) && (v3 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = triangle1[1];
                            triangle3[2] = points[t1];
                        }
                        if ((v0 == 1) && (v2 == 1)) {
                            triangle3[0] = points[i];
                            triangle3[1] = triangle1[0];
                            triangle3[2] = triangle1[2];
                        }
                        k3++;
                        f3 = 1;
                        t2 = i;
                    }
                }

                for (int i = t2+1; i < 16; i++) {
                    int k4 = 0;
                    int v0 = 0;
                    int v1 = 0;
                    int v2 = 0;
                    int v3 = 0;
                    int v4 = 0;
                    if ((points[i].x != 100) && (k4 < 1)) {
                        if ((Vector2.interectonPoint(points[i], triangle1[0], triangle1[2], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], triangle1[2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[1], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], triangle1[2], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[0], points[t1], points[t2]).x == 100)) v0 = 1;
                        if ((Vector2.interectonPoint(points[i], triangle1[1], triangle1[2], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], triangle1[2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[0], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], triangle1[2], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[1], points[t1], points[t2]).x == 100)) v1 = 1;
                        if ((Vector2.interectonPoint(points[i], triangle1[2], triangle1[0], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[1], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[1], triangle1[0]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[1], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], triangle1[0], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], triangle1[2], points[t1], points[t2]).x == 100)) v2 = 1;
                        if ((Vector2.interectonPoint(points[i], points[t1], triangle1[0], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[2], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[2], triangle1[0]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[0], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[1], points[t2]).x == 100) && (Vector2.interectonPoint(points[i], points[t1], triangle1[2], points[t2]).x == 100)) v3 = 1;
                        if ((Vector2.interectonPoint(points[i], points[t2], triangle1[0], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t2], triangle1[2], triangle1[1]).x == 100) && (Vector2.interectonPoint(points[i], points[t2], triangle1[2], triangle1[0]).x == 100) && (Vector2.interectonPoint(points[i], points[t2], triangle1[0], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], points[t2], triangle1[1], points[t1]).x == 100) && (Vector2.interectonPoint(points[i], points[t2], triangle1[2], points[t1]).x == 100)) v4 = 1;
                        if ((v0 == 1) && (v1 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[0];
                            triangle4[2] = triangle1[1];
                        }
                        if ((v1 == 1) && (v2 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[1];
                            triangle4[2] = triangle1[2];
                        }
                        if ((v2 == 1) && (v3 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[2];
                            triangle4[2] = points[t1];
                        }
                        if ((v3 == 1) && (v0 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = points[t1];
                            triangle4[2] = triangle1[0];
                        }
                        if ((v1 == 1) && (v3 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[1];
                            triangle4[2] = points[t1];
                        }
                        if ((v0 == 1) && (v2 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[0];
                            triangle4[2] = triangle1[2];
                        }
                        if ((v0 == 1) && (v4 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[0];
                            triangle4[2] = points[t2];
                        }
                        if ((v1 == 1) && (v4 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[1];
                            triangle4[2] = points[t2];
                        }
                        if ((v2 == 1) && (v4 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = triangle1[2];
                            triangle4[2] = points[t2];
                        }
                        if ((v3 == 1) && (v4 == 1)) {
                            triangle4[0] = points[i];
                            triangle4[1] = points[t1];
                            triangle4[2] = points[t2];
                        }
                        f4 = 1;
                        k4++;
                    }
                }
            }
            }
        if ((f1 == 1) && (f2 == 0)) s = Vector2.triangleArea(triangle1[0], triangle1[1], triangle1[2]);
        if ((f2 == 1) && (f3 == 0)) s = Vector2.triangleArea(triangle1[0], triangle1[1], triangle1[2]) + Vector2.triangleArea(triangle2[0], triangle2[1], triangle2[2]);
        if ((f3 == 1) && (f4 == 0)) s = Vector2.triangleArea(triangle1[0], triangle1[1], triangle1[2]) + Vector2.triangleArea(triangle2[0], triangle2[1], triangle2[2]) + Vector2.triangleArea(triangle3[0], triangle3[1], triangle3[2]);
        if (f4 == 1) s = Vector2.triangleArea(triangle1[0], triangle1[1], triangle1[2]) + Vector2.triangleArea(triangle2[0], triangle2[1], triangle2[2]) + Vector2.triangleArea(triangle3[0], triangle3[1], triangle3[2]) + Vector2.triangleArea(triangle4[0], triangle4[1], triangle4[2]);

        }
                // если точки являются разными
   //             if (p != p2) {
  //                  // если координаты у них совпадают
  //                  if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
   //                     p.isSolution = true;
   //                     p2.isSolution = true;
   //                 }
   //             }
   //         }
    //    }


    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
 //       rectangles.clear();
 //       try {
 //           File file = new File(FILE_NAME);
 //           Scanner sc = new Scanner(file);
 //           // пока в файле есть непрочитанные строки
 //           while (sc.hasNextLine()) {
 //               double x = sc.nextDouble();
 //               double y = sc.nextDouble();
 //               int setVal = sc.nextInt();
 //               sc.nextLine();
 //               Point point = new Point(x, y, setVal);
 //               rectangles.add(point);
 //           }
 //       } catch (Exception ex) {
  //          System.out.println("Ошибка чтения из файла: " + ex);
 //       }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
//        try {
//            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
//            for (Point point : rectangles) {
//                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
//            }
//            out.close();
//        } catch (IOException ex) {
//            System.out.println("Ошибка записи в файл: " + ex);
//        }
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
        //    Figures.renderPoint(gl, new Vector2(0.5, 0.5), 1);
        //    Figures.renderLine(gl, new Vector2(0.3,0.3), new Vector2(-0.3, -0.3), 1);
        //    Figures.renderTriangle(gl,  new Vector2(0.1, 0.1),  new Vector2(0.5, -0.5),  new Vector2(-0.5, 0.3), false);
        //    Figures.renderQuad(gl,  new Vector2(0.2, 0.2),  new Vector2(0.3, -0.3),  new Vector2(-0.3, 0.1), new Vector2(0.1, -0.7), true);
        //    Figures.renderCircle(gl,  new Vector2(0.1, 0.1),  0.6, false);
        //    Figures.renderCircle(gl,  new Vector2(0.1, 0.1),  0.6, false);
//        Rectangle[] arr = new Rectangle[5];
//        for (int i = 0; i < 5; i++) {
//            arr[i] = Rectangle.randomRectangle();
//            Rectangle.renderRectangle(gl, arr[i].A, arr[i].B, arr[i].C, arr[i].D, false);
//        }
    }
}
