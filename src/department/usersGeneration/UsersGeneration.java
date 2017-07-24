package department.usersGeneration;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Генерирование тестовых записей и запись их в файл
 * Created by psushenko on 12.07.2017.
 */
public class UsersGeneration {

    private static String pathIn = "C:\\Users\\psushenko\\Desktop\\userIn.txt";

    public static String getPathIn() {
        return pathIn;
    }

    public static void main(String[] args) {
        createFile();
    }

    public static void createFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathIn);
            for (int j = 0; j < 2; j++) { // количество отделов
                int additive = (int) (Math.random() * 3);
                for (int i = 0; i < 3 + additive; i++) { //количество людей в данном отделе
                    String s = (10 + 4 * j) + " name" + j + i + " " + (35000*(j + 1) + (int)(Math.random() * 100000)) + " ";
                    byte[] buffer = s.getBytes();
                    fileOutputStream.write(buffer, 0, buffer.length);
                }
            }
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
