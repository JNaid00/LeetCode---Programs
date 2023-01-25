class Solution {
    public static void main(String[] args) {
        ListNode[] arr = { new ListNode(2, new ListNode(3, new ListNode(4, null))),
                new ListNode(1, new ListNode(4, new ListNode(8, null))) };
        ListNode node = mergeKLists(arr);
        print(node);
        ListNode[] arr2 = { new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))), new ListNode(2, new ListNode(6, null)) };
        ListNode node2 = mergeKLists(arr2);
        print(node2);
        ListNode[] arr3 = {};
        ListNode node3 = mergeKLists(arr3);
        print(node3);
        ListNode[] arr4 = {null};
        ListNode node4= mergeKLists(arr4);
        print(node4);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, node = null;
        Boolean isNodeDone = true;
        if (lists.length == 0){
            return null;
        }
        while (isNodeDone) {
            int smallest = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode temp = lists[i];
                if (temp != null && temp.val < smallest) {
                    smallest = temp.val;
                    index = i;
                }
            }

            if (index == -1) {
                isNodeDone = false;
            } else {
                if (head == null) {
                    head = new ListNode(smallest, null);
                    node = head;

                } else {
                    node.next = new ListNode(smallest, null);
                    node = node.next;
                }
                lists[index] = lists[index].next;
            }
        }

        return head;
    }

    private static void print(ListNode node) {
        if (node == null) {
            System.out.println("List is empty");
            return;
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}