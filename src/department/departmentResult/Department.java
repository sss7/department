package department.departmentResult;

import department.avgSalary.AvgSalary;
import department.user.User;
import department.usersArray.UsersArray;
import department.usersGeneration.UsersGeneration;

import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by psushenko on 02.07.2017.
 */
public class Department {
//    public static String pathIn = "C:\\Users\\psushenko\\Desktop\\test.txt";
    private static String pathOut = "C:\\Users\\psushenko\\Desktop\\testOut.txt";
//    static ArrayList<ArrayList<User>> list = new ArrayList<ArrayList<User>>();
//    static ArrayList<Integer> avgSalary = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException{
        UsersGeneration.createFile();
//        ArrayList<User> listUsers = UsersArray.getUserListFromFile();
//        UsersArray.createDepartmentUserList(listUsers);
        UsersArray.getUsers();
//        UsersArray.printList();

        AvgSalary.createAvgSalary();
//        AvgSalary.printAvgSalary();
//        System.out.println(AvgSalary.countIncreaseSalaryVariants());
//        System.out.println("\n\n>>>>>>>>>>>>>>>\n");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathOut);

            for (int i = 0; i < AvgSalary.getAvgSalary().size(); i++) {
                for (int j = 0; j < AvgSalary.getAvgSalary().size(); j++) {
                    if (i != j && AvgSalary.getAvgSalary().get(i) < AvgSalary.getAvgSalary().get(j)) {
                        printVariants(fileOutputStream, i, j);
                    }
                }
            }
//            if (avgSalary.get(0) < avgSalary.get(1)) {
//                printVariants(fileOutputStream, 0, 1);
//            } else {
//                printVariants(fileOutputStream, 1, 0);
//            }
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

}

    /**
     * Генерирование тестовых записей
     */
//    public static void createFile() {
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(pathIn);
//            for (int j = 0; j < 2; j++) { // количество отделов
//                int additive = (int) (Math.random() * 3);
//                for (int i = 0; i < 3 + additive; i++) { //количество людей в данном отделе
//                    String s = (10 + 4 * j) + " name" + j + i + " " + (35000*(j + 1) + (int)(Math.random() * 100000)) + " ";
//                    byte[] buffer = s.getBytes();
//                    fileOutputStream.write(buffer, 0, buffer.length);
//                }
//            }
//            fileOutputStream.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    /**
//     * Чтение записей из файла и заполнение ArrayList'а
//     * @return
//     */
//    public static ArrayList<User> getUserListFromFile() {
//        ArrayList<User> listUsers = new ArrayList<User>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(UsersGeneration.pathIn);// pathIn);
//
//            int i = -1;
//            String s = "";
//            StringBuilder sb = new StringBuilder();
//
//            while ((i = fileInputStream.read()) != -1) {
//                char ch = (char) i;
//                System.out.print(ch);
//                sb.append(ch);
//            }
//
//            String users = sb.toString();
////            System.out.println("\n" + users);
//            Scanner scanner = new Scanner(users);
//            int department;
//            String name;
//            int salary;
//
//            User user;
//            while (scanner.hasNext()) {
//                department = scanner.nextInt();
//                name = scanner.next();
//                salary = scanner.nextInt();
////                System.out.print(department + " ");
////                System.out.print(name + " ");
////                System.out.println(salary);
//                user = new User(department, name, salary);
//                listUsers.add(user);
//            }
//
//            fileInputStream.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return listUsers;
//    }
//
//    /**
//     * Распределение пользователей по ArrayList'ам в зависимости от департамента
//     * @param listUsers
//     */
//    public static void createDepartmentUserList (ArrayList<User> listUsers) {
//
//        ArrayList<User> listUsersDep = new ArrayList<User>();
//
//        Object dep = -1;
//        for (User user : listUsers) {
//            if ((Object)(user.getDepartment()) != dep){
//                if (listUsersDep.size() != 0) {
//                    list.add(listUsersDep);
//                }
//                listUsersDep = new ArrayList<User>();
//                dep = user.getDepartment();
//            }
//            listUsersDep.add(user);
//        }
//        list.add(listUsersDep);
//
//    }
//
//    /**
//     * Распечатывание пользователей по департаментам
//     */
//    public static void printList () {
//        System.out.println();
//        for (ArrayList<User> users : list) {
//            System.out.println(">");
//            for (User u : users) {
//                System.out.println(u.getDepartment() + " " + u.getName() + " " + u.getSalary());
//            }
//        }
//    }

//    /**
//     * Вычисление средней зарплаты каждого отдела
//     */
//    public static void createAvgSalary () {
//        int departmentSalary;
//        for (ArrayList<User> users : UsersArray.list) {
//            departmentSalary = 0;
//            for (User u : users) {
//                departmentSalary += u.getSalary();
//            }
//            avgSalary.add(departmentSalary/users.size());
//        }
//    }
//
//    /**
//     * Распечатывание средние зарплаты всех отделов
//     */
//    public static void printAvgSalary () {
//        for (int i : avgSalary) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
//
//    /**
//     * Вычисление количества вариантов, удовлетворяющих условию
//     * Рассмотрен случай только с 2 отделами
//     * @return
//     */
//    public static int countIncreaseSalaryVariants () {
//        int countIncreaseSalaryVariants = 0;
//        if (avgSalary.get(1) >= avgSalary.get(0)) {
//            for (User u : UsersArray.list.get(1)) {
//                if (u.getSalary() <= avgSalary.get(1) && u.getSalary() >= avgSalary.get(0)) {
//                    countIncreaseSalaryVariants++;
//                }
//            }
//        } else {
//            for (User u : UsersArray.list.get(0)) {
//                if (u.getSalary() <= avgSalary.get(0) && u.getSalary() >= avgSalary.get(1)) {
//                    countIncreaseSalaryVariants++;
//                }
//            }
//        }
//
//        return countIncreaseSalaryVariants;
//    }

    /**
     * Запись варианта, удовлетворяющего условию, в файл
     * @param fileOutputStream - файл для записи
     * @param dep1 - первый департамент
     * @param dep2 - второй департамент
     * @throws IOException
     */
    public static void printVariants(FileOutputStream fileOutputStream, int dep1, int dep2) throws IOException{
//        int countIncreaseSalaryVariants = 0;
        String s;
        byte[] buffer;

        if (AvgSalary.getAvgSalary().get(dep2) >= AvgSalary.getAvgSalary().get(dep1)) {
            for (User u : UsersArray.getList().get(dep2)) {
                if (u.getSalary() <= AvgSalary.getAvgSalary().get(dep2) && u.getSalary() >= AvgSalary.getAvgSalary().get(dep1)) {
//                    countIncreaseSalaryVariants++;

                    for (User u0 : UsersArray.getList().get(dep1)) {
                        s = u0.getDepartment() + " " + u0.getName() + " " + u0.getSalary() + " ";
                        buffer = s.getBytes();
                        fileOutputStream.write(buffer, 0, buffer.length);
                    }

                    s = u.getDepartment() + " " + u.getName() + " " + u.getSalary() + " > ";
                    buffer = s.getBytes();
                    fileOutputStream.write(buffer, 0, buffer.length);

                    for (User u1 : UsersArray.getList().get(dep2)) {
                        if (!u1.equals(u)) {
                            s = u1.getDepartment() + " " + u1.getName() + " " + u1.getSalary() + " ";
                            buffer = s.getBytes();
                            fileOutputStream.write(buffer, 0, buffer.length);
                        }
                    }

                    s = " >>> \n";
                    buffer = s.getBytes();
                    fileOutputStream.write(buffer, 0, buffer.length);

                }
            }
        }
    }


}
