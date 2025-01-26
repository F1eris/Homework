import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private final ArrayList<PersonData> dataArrayList = new ArrayList<>();

    /**
     * Добавить строку в справо чник
     *
     * @param lastName    фамилия
     * @param phoneNumber номер телефона
     * @return true, если успешно добавлен
     */
    public boolean add(String lastName, String phoneNumber) {
        //Если в листе уже существует такой номер
        if (getAllNumbers().contains(phoneNumber)) {
            System.out.printf("Номер %s уже содержится в справочнике\n", phoneNumber);
            return false;
        }

        return dataArrayList.add(new PersonData(lastName, phoneNumber));
    }

    /**
     * Получить лист номеров по фамилии
     *
     * @param lastName фамилия
     * @return лист со всеми номерами по переданной фамилии
     */
    public List<String> get(String lastName) {
        List<String> phoneNumbers = new ArrayList<>();

        for (PersonData data : dataArrayList) {
            if (data.getLastName().equalsIgnoreCase(lastName)) {
                phoneNumbers.add(data.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }

    /**
     * ВСЕ номера из справочника
     *
     * @return лист номеров
     */
    private List<String> getAllNumbers() {
        List<String> allNumbers = new ArrayList<>();
        for (PersonData data : dataArrayList) {
            allNumbers.add(data.getPhoneNumber());
        }
        return allNumbers;
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
