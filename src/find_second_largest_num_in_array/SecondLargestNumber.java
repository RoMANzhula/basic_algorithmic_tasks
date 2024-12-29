package find_second_largest_num_in_array;

public class SecondLargestNumber {

    public static void main(String[] args) {
        int[] nums = {10, 21, 4, 47, 97};
        System.out.println(findSecondLargestNum(nums)); // 47
    }

    private static int findSecondLargestNum(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

}
