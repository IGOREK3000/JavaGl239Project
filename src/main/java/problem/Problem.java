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
        // перебираем пары точек
//        for (Point p : rectangles) {
//            for (Point p2 : rectangles) {
//                // если точки являются разными
//                if (p != p2) {
//                    // если координаты у них совпадают
//                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
//                        p.isSolution = true;
//                        p2.isSolution = true;
//                    }
//                }
//            }
//        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
//        rectangles.clear();
//        try {
//            File file = new File(FILE_NAME);
//            Scanner sc = new Scanner(file);
//            // пока в файле есть непрочитанные строки
//            while (sc.hasNextLine()) {
//                double x = sc.nextDouble();
//                double y = sc.nextDouble();
//                int setVal = sc.nextInt();
//                sc.nextLine();
//                Point point = new Point(x, y, setVal);
//                rectangles.add(point);
//            }
//        } catch (Exception ex) {
//            System.out.println("Ошибка чтения из файла: " + ex);
//        }
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
