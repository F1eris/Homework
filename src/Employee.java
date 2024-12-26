//Задание 1
public class Employee {
    private String fullName;
    private String position;
    private String mail;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String mail, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    //Выводит информацию в консоль
    public void showInfo() {
        System.out.printf("%s\n%s\n%s\n%s\n%d\n%d\n\n", fullName, position, mail, phoneNumber, salary, age);
    }
}
