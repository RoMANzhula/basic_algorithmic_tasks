package binary_search_sorted_array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array1 = {1, 4, 9, 22, 125, 456};
        System.out.println(indexBinarySearch(array1, 22)); // 3

        // with recursion
        int[] array2 = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(indexBinarySearchRecursion(array2, 4, 0, array2.length - 1)); // 2
    }

    private static int indexBinarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) return mid;

            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }


    private static int indexBinarySearchRecursion(int[] array, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (array[mid] == target) return mid;

        if (array[mid] > target) return indexBinarySearchRecursion(array, target, left, mid - 1);

        return indexBinarySearchRecursion(array, target, mid + 1, right);
    }

}
