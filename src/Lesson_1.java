import java.util.Random;
import java.util.Scanner;

public class Lesson_1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {

//        System.out.printf("Длина массива %d\n", task2();
task2();

    }

    /**
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
     */

//   static int task1(int[] arr){
//       if(arr.length < 1){
//           return -1;
//       }
//       return arr.length;
//   }
    /**
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     3. если вместо массива пришел null, метод вернет -3
     Напишите метод, в котором реализуйте взаимодействие с пользователем.
     То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     обработает возвращенное значение и покажет читаемый результат пользователю.
     Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */
    static void task2(){
        while (true){
            System.out.println("Укажите число для поиска ");
            if (scanner.hasNextInt()){
                int searchNumb = scanner.nextInt();
                int[] arr = new int[random.nextInt((5)+1)];
                if (random.nextInt(2) == 0){
                    arr = null;
                }
                else{
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(10);
                        System.out.printf("%d\t", arr[i]);


                    }
                    System.out.println("");
                }
                int codeResult = processArray(arr, searchNumb);
                if(codeResult == -1){
                    System.out.println("Длина массива менее 3 элементов");
                } else if (codeResult == -2) {
                    System.out.println("Элемент не найден");

                } else if (codeResult == -3) {
                    System.out.println("Массив не корректоно проинициализирован");

                }
                else {
                    System.out.println("массив успешно обработан");
                    System.out.printf("Элемент найден по индексу %d\n", codeResult);
                }

            }else {
                System.out.println("Число указано не корректно");
                scanner.nextLine();
            }
        }
    }

static int processArray(int[] arr, int searchNumb){
        if(arr == null){
            return  -3;

        }
        if (arr.length<3)
            return -1;
    for (int i = 0; i < arr.length; i++) {
        if(arr[i] == searchNumb)
            return i;

    } return -2;
}

}
//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//
//        Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//
//        Метод divisionByZero - Деление на 0
//
//        Метод numberFormatException - Ошибка преобразования строки в число

//class Answer {
//    public static void arrayOutOfBoundsException() {
//        int[] array = new int[5];
//        int el = array[10];
//    }
//
//    public static void divisionByZero() {
//        // Напишите свое решение ниже
//        int numb = 10;
//        int result = numb / 0;
//
//    }
//
//    public static void numberFormatException() {
//        // Напишите свое решение ниже
//        String str = "abcd";
//        int number = Integer.parseInt(str);
//
//    }
//}
//
//public class Printer {
//    public static void main(String[] args) {
//        Answer ans = new Answer();
//        try {
//            ans.arrayOutOfBoundsException();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Выход за пределы массива");
//        }
//
//        try {
//            ans.divisionByZero();
//        } catch (ArithmeticException e) {
//            System.out.println("Деление на ноль");
//        }
//
//        try {
//            ans.numberFormatException();
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка преобразования строки в число");
//        }
//    }
//}