package department.user;

/**
 * Класс пользователя
 * Created by psushenko on 02.07.2017.
 */
public class User {
    private int department;
    private String name;
    private int salary;

    public User(int department, String name, int salary) {
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
