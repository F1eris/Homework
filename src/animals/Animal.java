package animals;

public abstract class Animal {
    private static int animalCounter;
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;


    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public void run(int distance) {
        if (maxRunDistance == 0) {
            System.out.println(name + " не умеет бегать");
            return;
        }

        if (distance > maxRunDistance) {
            System.out.println(name + " может пробежать не больше " + maxRunDistance + " м");
        } else {
            System.out.println(name + " пробежал " + distance + " м");
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать");
            return;
        }

        if (distance > maxSwimDistance) {
            System.out.println(name + " может проплыть не больше " + maxRunDistance + " м");
        } else {
            System.out.println(name + " проплыл " + distance + " м");
        }
    }


    public static int getAnimalCounter() {
        return animalCounter;
    }

    public String getName() {
        return name;
    }
}
