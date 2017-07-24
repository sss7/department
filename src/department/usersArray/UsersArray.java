package department.usersArray;

import department.user.User;
import department.usersGeneration.UsersGeneration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Чтение записей из файла и распределение их по ArrayList'ам
 * Created by psushenko on 12.07.2017.
 */
public class UsersArray {

    private static ArrayList<ArrayList<User>> list = new ArrayList<ArrayList<User>>();

    public static ArrayList<ArrayList<User>> getList() {
        return list;
    }

    public static void main(String[] args) {
        getUsers();
//        printList();
    }

    public static void getUsers() {
        ArrayList<User> listUsers = getUserListFromFile();
        createDepartmentUserList(listUsers);
    }

    /**
     * Чтение записей из файла и заполнение ArrayList'а
     * @return
     */
    public static ArrayList<User> getUserListFromFile() {
        ArrayList<User> listUsers = new ArrayList<User>();
        try {
            FileInputStream fileInputStream = new FileInputStream(UsersGeneration.getPathIn());

            int i = -1;
            String s = "";
            StringBuilder sb = new StringBuilder();

            while ((i = fileInputStream.read()) != -1) {
                char ch = (char) i;
                System.out.print(ch);
                sb.append(ch);
            }

            String users = sb.toString();
//            System.out.println("\n" + users);
            Scanner scanner = new Scanner(users);
            int department;
            String name;
            int salary;

            User user;
            while (scanner.hasNext()) {
                department = scanner.nextInt();
                name = scanner.next();
                salary = scanner.nextInt();
//                System.out.print(department + " ");
//                System.out.print(name + " ");
//                System.out.println(salary);
                user = new User(department, name, salary);
                listUsers.add(user);
            }

            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listUsers;
    }

    /**
     * Распределение пользователей по ArrayList'ам в зависимости от департамента
     * @param listUsers
     */
    public static void createDepartmentUserList (ArrayList<User> listUsers) {

        ArrayList<User> listUsersDep = new ArrayList<User>();

        Object dep = -1;
        for (User user : listUsers) {
            if ((Object)(user.getDepartment()) != dep){
                if (listUsersDep.size() != 0) {
                    list.add(listUsersDep);
                }
                listUsersDep = new ArrayList<User>();
                dep = user.getDepartment();
            }
            listUsersDep.add(user);
        }
        list.add(listUsersDep);

    }

    /**
     * Распечатывание пользователей по департаментам
     */
//    public static void printList () {
//        System.out.println();
//        for (ArrayList<User> users : list) {
//            System.out.println(">");
//            for (User u : users) {
//                System.out.println(u.getDepartment() + " " + u.getName() + " " + u.getSalary());
//            }
//        }
//    }

}
