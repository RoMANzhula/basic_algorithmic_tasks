package string_permutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String[] args) {
        List<String> result1 = new ArrayList<>();
        permute("abc", "", result1);
        System.out.println(result1);
    }

    private static void permute(String str, String perm, List<String> result) {
        if (str.length() == 0) {
            result.add(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            permute(ros, perm + ch, result);
        }
    }

}
