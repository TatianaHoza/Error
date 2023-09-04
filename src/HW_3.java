import java.io.*;
import java.nio.file.FileSystemException;

public class HW_3 {
    public static void main(String[] args) throws IOException {
        try {
            takeInfo();
            System.out.println("success");
        }catch (FileSystemException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }



    }

    public static void takeInfo() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, номер телефона (число без разделителей), разделенные пробелом");

        String result;

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            result = bf.readLine();
        }catch (IOException e){
            throw new Exception("Произошла ошибка.");
        }

        String[] array = result.split(" ");
        if (array.length != 4){
            throw new Exception("Введено неверное количество параметров");
        }
        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];

        int phone;
        try {
            phone = Integer.parseInt(array[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверный формат телефона");
        }

        String fileName = "files\\" + surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s", surname, name, patronymic, phone));
        }catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }


    }

}
