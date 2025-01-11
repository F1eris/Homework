import java.util.ArrayList;

//Задание 3
public class Park {
    private final ArrayList<Park.Attraction> attractions = new ArrayList<>();

    public void addAttraction(String description, String workingHours, int cost){
        attractions.add(new Attraction(description, workingHours, cost));
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }


    public class Attraction {
        private String description;
        private String workingHours;
        private int cost;

        public Attraction(String description, String workingHours, int cost) {
            this.description = description;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public void showInfo() {
            System.out.printf("Описание: %s\nРабочие часы: %s\nСтоимость: %d\n", description, workingHours, cost);
        }
    }
}
