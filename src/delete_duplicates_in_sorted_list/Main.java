package delete_duplicates_in_sorted_list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // head = [1,1,2]
        ListNode test1 = new ListNode(1, new ListNode(1, new ListNode(2)));
//        test1 = deleteDuplicates(test1);
        test1 = getUniqueValues(test1);
        System.out.println("Output for test1: " + toArrayList(test1)); // Output: [1, 2]

        // head = [1,1,2,3,3]
        ListNode test2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
//        test2 = deleteDuplicates(test2);
        test2 = getUniqueValues(test2);
        System.out.println("Output for test2: " + test2); // Output: [1, 2, 3]

        // head = [4,4,4,4]
        ListNode test3 = new ListNode(4, new ListNode(4, new ListNode(4, new ListNode(4))));
        test3 = deleteDuplicates(test3);
//        test3 = getUniqueValues(test3);
        System.out.println("Output for test3: " + test3); // Output: [4]

        // head = []
        ListNode test4 = null;
        test4 = deleteDuplicates(test4);
        System.out.println("Output for test4: " + test4); // Output: []

        // head = [1,2,3,4,5]
        ListNode test5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        test5 = deleteDuplicates(test5);
//        test5 = getUniqueValues(test5);
        System.out.println("Output for test5: " + test5); // Output: [1, 2, 3, 4, 5]
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode currentNode = head; // save initial(start) node

        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        return head; // link to the initial(start) node
    }


    public static ListNode getUniqueValues(ListNode head) {
        Set<Integer> uniqueValues = new HashSet<>();
        ListNode dummy = new ListNode(0); // temporary node to build new list
        ListNode current = dummy;

        while (head != null) {
            if (uniqueValues.add(head.val)) { // add only uniq values
                current.next = new ListNode(head.val);
                current = current.next;
            }
            head = head.next;
        }
        return dummy.next; // new list without duplicates
    }


    public static List<Integer> toArrayList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

}

