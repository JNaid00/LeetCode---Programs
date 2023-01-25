import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        ListNode[] arr = { new ListNode(2, new ListNode(3, new ListNode(4, null))),
                new ListNode(1, new ListNode(4, new ListNode(8, new ListNode(11, new ListNode(15, null))))) };
        ListNode node = mergeKListsMinHeap(arr);
        print(node);
        ListNode[] arr2 = { new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))), new ListNode(2, new ListNode(6, null)) };
        ListNode node2 = mergeKListsMinHeap(arr2);
        print(node2);
        ListNode[] arr3 = {};
        ListNode node3 = mergeKListsMinHeap(arr3);
        print(node3);
        ListNode[] arr4 = { null };
        ListNode node4 = mergeKListsMinHeap(arr4);
        print(node4);
    }

    public static ListNode mergeKListsMinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        if (pq.isEmpty())
            return null;
        ListNode head = null, node = null;
        while (pq.isEmpty() == false) {
            ListNode temp = pq.remove();
            if (head == null) {
                head = temp;
                node = head;

            } else {
                node.next = temp;
                node = node.next;
            }

            if (temp.next != null) {
                pq.add(temp.next);
            }

            temp.next = null;
        }
        return head;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, node = null;
        Boolean isNodeDone = true;
        if (lists.length == 0) {
            return null;
        }
        while (isNodeDone) {
            int smallest = Integer.MAX_VALUE;
            int index = -1;

            ListNode temp = null;
            for (int i = 0; i < lists.length; i++) {

                if (lists[i] != null && lists[i].val < smallest) {
                    temp = lists[i];
                    smallest = temp.val;
                    index = i;
                }
            }

            if (index == -1) {
                isNodeDone = false;
            } else {
                if (head == null) {
                    head = temp;
                    node = head;

                } else {
                    node.next = temp;
                    node = node.next;
                }
                lists[index] = lists[index].next;
                temp.next = null;
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