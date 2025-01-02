package animals;

public class Dog extends Animal {
    private static int dogCounter;

    public Dog(String name) {
        super(name);
        maxRunDistance = 500;
        maxSwimDistance = 10;
        dogCounter++;
    }

    public static int getDogCounter() {
        return dogCounter;
    }
}
