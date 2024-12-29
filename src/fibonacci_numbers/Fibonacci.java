package fibonacci_numbers;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(10)); // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 = 55

        // with recursion
        System.out.println(fibonacciRecursion(6)); // 0, 1, 1, 2, 3, 5, 8 = 8
    }

    private static long fibonacci(int number) {
        if (number <= 1) return number;

        int prev1 = 0, prev2 = 1, result = 0;

        for (int i = 2; i <= number; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    
    private static long fibonacciRecursion(int number) {
        if (number <= 1) return number;

        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }

}
