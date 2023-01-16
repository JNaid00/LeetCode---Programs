public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        print(node);
        print(removeNthFromEndTwoPointer(node, 3));
        System.out.println();
        ListNode node2 = new ListNode(2, new ListNode(4,null));
        node2 = removeNthFromEndTwoPointer(node2, 2);
        print(node2);
        
        ListNode node11 = new ListNode(7,
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(5,
                                        new ListNode(4,
                                                new ListNode(8,
                                                        new ListNode(9, null)))))));

        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 1);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 3);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 5);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 3);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 1);
        print(node11); node11 = removeNthFromEndTwoPointer(node11, 2);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 2);
        print(node11);
        node11 = removeNthFromEndTwoPointer(node11, 1);
        print(node11);
    }

    private static void print(ListNode node) {
        if (node == null){
            System.out.println("List is empty");
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
    public static ListNode removeNthFromEndTwoPointer(ListNode head, int n) {
        ListNode node1 = head, node2 = head;

        for (int i = 0; i < n; i++) {
            node2 = node2.next;
        }

        if (node2 == null){
            ListNode temp = node1.next;
            node1.next = null;
            return temp;
        }
        while(node2.next != null){
            node2 = node2.next;
            node1 = node1.next;
        }

     
        if(node1.next == node2){
            node1.next = null;
            return head;
        }

        ListNode temp = node1.next;
        node1.next = temp.next;
        return head;


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
