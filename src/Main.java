public class Main {
    public static void main(String[] args) {
        //Проверка задания 1
        Employee employee1 = new Employee("Pupkin Vasya", "Java junior developer",
                "pupkinV@mail.ru", "88888888888", 100000, 20);
        employee1.showInfo();

        //Задание 2
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Pupkin Vasya", "Java junior developer",
                "pupkinV@mail.ru", "88888888888", 100000, 20);
        employees[1] = new Employee("Vupkin Pasya", "Dava dunior jeveloper",
                "vupkinP@gmail.com", "81234567890", 50000, 50);
        employees[2] = new Employee("Ivanov ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[3] = new Employee("Petrov Petr", "Team lead",
                "petrovPetr@mail.ru", "80000000000", 300000, 43);
        employees[4] = new Employee("Dmitriev Dmitrii", "senior cleaner",
                "dmitrievD@gmail.com", "81111111111", 45000, 75);
        //Проверка задания 2
        for (Employee employee : employees) {
            employee.showInfo();
        }

        //Проверка задания 3
        Park park = new Park();
        for (Park.Attraction attraction : park.getAttractions()) {
            attraction.showInfo();
        }


    }
}