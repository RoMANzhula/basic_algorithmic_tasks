package first_char_duplicate_in_string;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();

        System.out.println(solution.findFirstDuplicateUsingSet("abcdefa")); // output 6 (start from 0) as 7-th element
        System.out.println(solution.findFirstDuplicateUsingNestedLoop("abcdc")); // output 4 (start from 0) as 5-th element
        System.out.println(solution.findFirstDuplicateUsingArray("abcded")); // output 5 (start from 0) as 6-th element
    }

    // time and space complexity O(n), where n = inputStr.length()
    private int findFirstDuplicateUsingSet(String inputStr) {
        int lengthStr = inputStr.length();

        if (lengthStr == 1) return lengthStr;

        // our buffer
        Set<Character> seenChars = new HashSet<>();

        for (int i = 0; i < lengthStr; i++) {
            char currentChair = inputStr.charAt(i);

            // if already has - return index
            if (seenChars.contains(currentChair)) return i;

            // if not has - add to collection
            seenChars.add(currentChair);
        }

       // if no duplicate is found
       return -1;
    }

    // time complexity O(n^2), no extra space (because doesn't use any array or collections)
    private int findFirstDuplicateUsingNestedLoop(String inputStr) {
        int lengthStr = inputStr.length();

        // iterate through input string
        for (int i = 0; i < lengthStr; i++) {
            // compare the current chair with subsequent character
            for (int j = i + 1; j < lengthStr; j++) {
                // if a duplicate is found - return index
                if (inputStr.charAt(i) == inputStr.charAt(j)) return j;
            }
        }

        // for all uniq chars
        return -1;
    }


    // time and space complexity O(n), where n = inputStr.length()
    private int findFirstDuplicateUsingArray(String inputStr) {
        int lengthStr = inputStr.length();

        //array to track visited chars
        boolean[] seen = new boolean[26];

        // iterate through the inputStr
        for (int i = 0; i < lengthStr; i++) {
            char currentChar = inputStr.charAt(i);

            // calculate the index in the seen for the currentChar
            int index = currentChar - 'a';

            // if the char has been seen before - return its index
            if (seen[index]) return i;

            // mark the char as seen
            seen[index] = true;
        }

        // if no duplicate
        return -1;

    }


}
