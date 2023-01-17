class Solution {
    public static void main(String[] args) {
        ListNode node = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))));
        print(node);
        ListNode node2 = mergeTwoLists(null, null);
        print(node2);
        ListNode node3 = mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(10, new ListNode(15, null))))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))));
        print(node3);

    }

    private static void print(ListNode node) {
        if (node == null) {
            System.out.println("List is empty");
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = null;
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head = new ListNode(list2.val);
                list2 = list2.next;
            }
        } else {
            return list1 == null ? list2 : list1;
        }
        ListNode node = null, nodePrev = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                node = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }

            nodePrev.next = node;
            nodePrev = node;
            node = node.next;
        }
        if (list1 != null){
            nodePrev.next = list1;
        }else if(list2 != null){
            nodePrev.next = list2;
        }
        return head;
    }
}