public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        print(node);
        print(removeNthFromEnd(node, 3));

        ListNode node11 = new ListNode(7,
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(5,
                                        new ListNode(4,
                                                new ListNode(8,
                                                        new ListNode(9, null)))))));

        print(node11);
        node11 = removeNthFromEnd(node11, 1);
        print(node11);
        node11 = removeNthFromEnd(node11, 3);
        print(node11);
        node11 = removeNthFromEnd(node11, 5);
        print(node11);
        node11 = removeNthFromEnd(node11, 3);
        print(node11);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head;

        for (int i = 0; i < count - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            ListNode temp = curr.next;
            curr.next = null;
            return temp;
        }

        if (curr.next == null) {
            prev.next = null;
            return head;
        }

        prev.next = curr.next;
        curr.next = null;

        return head;
    }
}
