import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static float requestFloat() {
        Scanner in = new Scanner(System.in);
        var input = in.nextLine();
        float f = 0;
        try {
            f = Float.parseFloat(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public static void task1() {
        boolean doInput = true;
        float f = 0;

        while (doInput) {
            doInput = false;
            System.out.println("type float pls:");
            try {
                f = requestFloat();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                doInput = true;
            }
        }
        System.out.println("you typed: " + f);
    }

    //2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    public static void task2(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    //Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    public static void task3(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    //2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    public static String task4() throws Exception {
        Scanner in = new Scanner(System.in);
        var input = in.nextLine();
        if (input == "") {
            throw new Exception("Пустые строки вводить нельзя");
        }
        return input;
    }

    public static void main(String[] args) {
        //task1();
        //task2(new int[2]);
        //task3(args);
        var s = "";
        try {
            System.out.println("type str:");
            s = task4();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("you typed: " + s);
    }
}