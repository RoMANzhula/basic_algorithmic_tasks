package check_number_for_simplicity;

public class PrimeCheck {

    public static void main(String[] args) {
        System.out.println(isPrime(29)); // true
        System.out.println(isPrime(18)); // false

        // with recursion
        int num = 29;
        System.out.println(isPrimeRecursion(num, num / 2)); // true
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }


    private static boolean isPrimeRecursion(int number, int divisor) {
        if (number <= 1) return false;

        if (divisor == 1) return true;

        if (number % divisor == 0) return false;

        return isPrimeRecursion(number, divisor - 1);
    }

}
