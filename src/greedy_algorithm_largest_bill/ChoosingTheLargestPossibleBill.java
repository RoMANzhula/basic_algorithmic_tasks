package greedy_algorithm_largest_bill;

import java.util.Arrays;

public class ChoosingTheLargestPossibleBill {

    public static void main(String[] args) {
        int[] banknotes = {100, 500, 200};
        int amount = 2800;
        int result = minBanknotes(banknotes, amount);
        System.out.println(result == -1 ? "Unable to issue amount" : "Minimum numbers of bill: " + result);
    }


    private static int minBanknotes(int[] banknotes, int amount) {
        Arrays.sort(banknotes);

        int len = banknotes.length, count = 0;

        for (int i = len - 1; i >= 0; i--) {
            count += amount / banknotes[i];
            amount -= (amount / banknotes[i]) * banknotes[i];
        }

        return amount == 0 ? count : -1;
    }

}
