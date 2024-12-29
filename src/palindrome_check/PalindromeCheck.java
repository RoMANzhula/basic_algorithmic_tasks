package palindrome_check;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("word")); // false

        // with recursion
        String str1 = "racecar";
        String str2 = "word";
        System.out.println(isPalindromeRecursion(str1, 0, str1.length() - 1)); // true
        System.out.println(isPalindromeRecursion(str2, 0, str2.length() - 1)); // false
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    private static boolean isPalindromeRecursion(String str, int left, int right) {
        if (left > right) return true;

        if (str.charAt(left) != str.charAt(right)) return false;

        return isPalindromeRecursion(str, left + 1, right - 1);
    }


}
