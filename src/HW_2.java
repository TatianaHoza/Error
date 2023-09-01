import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW_2 {

    public static void main(String[] args) {
        //task1();

        //task2();

        //task3();

        task4();

    }
    //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
    // приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static float getFloat(BufferedReader bufferedReader) {
        System.out.println("Введите число");
        float result;
        try {
            result = Float.parseFloat(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка");
            return getFloat(bufferedReader);
        } catch (Exception e) {
            System.out.println("Ошибка при получении числа");
            return getFloat(bufferedReader);
        }
        return result;
    }

    public static void task1() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            float result = getFloat(bufferedReader);
            bufferedReader.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
            return;
        }


    }

    // Задание 2
//    try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//    } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//    }

    public static void task2() {
        try {
            int d = 0;
            int[] intArray = new int[10];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    //Задание 3

    public static void task3() {


        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        }  catch (NullPointerException e) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }

        }
        public static void printSum(Integer a, Integer b) {
            System.out.println(a + b);
    }

    //Разработайте программу, которая выбросит Exception, когда пользователь
    // вводит пустую строку. Пользователю должно показаться сообщение,
    // что пустые строки вводить нельзя.

    public static void task4() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            boolean isContinue = true;
            while (isContinue){
                try {
                    System.out.println("Введите строку");
                    String text = getTextFromUser(bufferedReader);
                    System.out.println(text);
                    isContinue = false;
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка");
        }

    }

    public static String getTextFromUser(BufferedReader bufferedReader) throws IOException{
        String text = bufferedReader.readLine();

        if (text.isEmpty()){
            throw new RuntimeException("Введена пустая строка");
        }

        return text;
    }

    }



