package factorial_of_number;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(4)); // 1 * 2 * 3 * 4 = 24
        System.out.println(factorial(5)); // 1 * 2 * 3 * 4 * 5 = 120
    }

    private static long factorial(int number) {
        if (number == 0 || number == 1) return 1; // or if (number <= 1)

        return number * factorial(number - 1);
    }

}
