import java.util.Random;

public class Lesson_2 {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     * MyArrayDataException и вывести результат расчета.
     */
    static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n ****Iteracia %d ***\n\n", i+1);
            processArray();

        }


    }

    static void processArray(){
        try{
            System.out.printf("Sum %d\n",processArrayInternal(generateArray()));

        }
        catch (MyArrayDataException e){
            System.out.printf("%s\n Элемент под индексом [%d][%d]\n", e.getMessage(), e.getX(),e.getY());
        }
        catch(MyArraySizeException e){
            System.out.printf("%s\n требуется ввести массив 4*4 получили %d * %d\n", e.getMessage(),e.getX(),e.getY());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            {
                System.out.println("Завершение обработки");
            }
        }
    }

    static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] arr = new String[4 + add][4 + add];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (random.nextInt(50) <2){
                    arr[i][j] = "aaa";
                }
else {
    arr[i][j] = Integer.toString(random.nextInt(100));
                }
                System.out.printf("%s", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }


    static int processArrayInternal(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length !=4 || arr[0].length !=4){
            throw new MyArraySizeException("Не корректный размер массива", arr.length,arr[0].length);

        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length ; j++) {
                sum+= parseElement(arr[i][j],i,j);

            }
        }
        return sum;
    }
static int parseElement(String st,int i,int j) throws MyArrayDataException {
        try{
            return Integer.parseInt(st);
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("Некорректный формат данных", i, j);
        }
}

}

abstract class MyException extends Exception{
    private final int x;
    private final int y;

    public MyException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
        }

    public int getX(){
        return x;
    }
        public int getY(){
        return y;
        }



}

class MyArraySizeException extends MyException {
    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }
}

    class MyArrayDataException extends MyException {
        public MyArrayDataException(String message, int x, int y) {
            super(message, x, y);
        }


    }

