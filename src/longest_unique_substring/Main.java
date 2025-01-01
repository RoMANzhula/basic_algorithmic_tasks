package longest_unique_substring;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a string (or type 'stop' to exit): ");
            String input = scanner.nextLine(); // Reading input strings

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Exiting the program.");
                break;
            }

            Map<String, Integer> result = solution.findLongestUniqueSubstring(input);

            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(
                        "Longest unique substring: \"" + entry.getKey()
                        + "\", Length: " + entry.getValue()
                );
            }
        }

        scanner.close();
    }

    public Map<String, Integer> findLongestUniqueSubstring(String inputStr) {
        Map<String, Integer> result = new HashMap<>();

        // set to track unique characters in the current window
        Set<Character> uniqueChars = new HashSet<>();

        int maxLength = 0; // to store the substring length
        int leftPointer = 0; // for sliding window
        int lengthStr = inputStr.length();
        String longestSubstring = "";

        // iterate through the input string with the right pointer
        for (int right = 0; right < lengthStr; right++) {
            char currentChar = inputStr.charAt(right);

            // if char is in the Set - move the left pointer and remove chars from the Set
            // until the duplicate is removed
            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(inputStr.charAt(leftPointer));
                leftPointer++;
            }

            // add current char to the Set
            uniqueChars.add(currentChar);

            if (right - leftPointer + 1 > maxLength) {
                // and update max length of the longest substring
                maxLength = Math.max(maxLength, right - leftPointer + 1);

                // build substring
                longestSubstring = inputStr.substring(leftPointer, right + 1);
            }

        }

        result.put(longestSubstring, maxLength);

        return result;
    }

}
