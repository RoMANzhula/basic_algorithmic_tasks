package reverse_string;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("hello")); // olleh

        // with recursion
        System.out.println(reverseRecursion("world")); // dlrow
    }

    private static String reverse(String str) {
        StringBuilder builder = new StringBuilder(str);

        return builder.reverse().toString();
    }


    private static String reverseRecursion(String str) {
        if (str.isEmpty()) return str;

        return reverse(str.substring(1)) + str.charAt(0);
    }

}
