import java.util.ArrayList;

public class TelephoneDirectory {
    private final ArrayList<PersonData> dataArrayList = new ArrayList<>();

    public void add(String lastName, String phoneNumber) {
        dataArrayList.add(new PersonData(lastName, phoneNumber));
    }

    public void get(String lastName) {
        System.out.printf("Телефонные номера по фамилии %s:\n", lastName);
        for (PersonData data : dataArrayList) {
            if (data.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(data.getPhoneNumber());
            }
        }
    }

    /**
     * Класс единицы/строки телефонного справочника
     */
    private class PersonData {
        private String lastName;
        private String phoneNumber;

        public PersonData(String lastName, String phoneNumber) {
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
