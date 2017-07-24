package department.avgSalary;

import department.user.User;
import department.usersArray.UsersArray;

import java.util.ArrayList;

/**
 * Вычисление средних зарплат по отделам
 * Created by psushenko on 12.07.2017.
 */
public class AvgSalary {

    private static ArrayList<Integer> avgSalary = new ArrayList<Integer>();

    public static ArrayList<Integer> getAvgSalary() {
        return avgSalary;
    }

    public static void main(String[] args) {

    }

    /**
     * Вычисление средней зарплаты каждого отдела
     */
    public static void createAvgSalary () {
        int departmentSalary;
        for (ArrayList<User> users : UsersArray.getList()) {
            departmentSalary = 0;
            for (User u : users) {
                departmentSalary += u.getSalary();
            }
            avgSalary.add(departmentSalary/users.size());
        }
    }

    /**
     * Распечатывание средние зарплаты всех отделов
     */
    public static void printAvgSalary () {
        for (int i : avgSalary) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Вычисление количества вариантов, удовлетворяющих условию
     * Рассмотрен случай только с 2 отделами
     * @return
     */
//    public static int countIncreaseSalaryVariants () {
//        int countIncreaseSalaryVariants = 0;
//        if (avgSalary.get(1) >= avgSalary.get(0)) {
//            for (User u : UsersArray.getList().get(1)) {
//                if (u.getSalary() <= avgSalary.get(1) && u.getSalary() >= avgSalary.get(0)) {
//                    countIncreaseSalaryVariants++;
//                }
//            }
//        } else {
//            for (User u : UsersArray.getList().get(0)) {
//                if (u.getSalary() <= avgSalary.get(0) && u.getSalary() >= avgSalary.get(1)) {
//                    countIncreaseSalaryVariants++;
//                }
//            }
//        }
//
//        return countIncreaseSalaryVariants;
//    }

}
