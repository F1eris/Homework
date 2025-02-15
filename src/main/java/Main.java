import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(1000));
    }

    public static BigInteger getFactorial(int f) {
        if(f < 0){
            throw new IllegalArgumentException("Факториалы отрицательных чисел не определены");
        }
        else if(f == 0 || f == 1){
            return BigInteger.ONE;
        }
        else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }
}