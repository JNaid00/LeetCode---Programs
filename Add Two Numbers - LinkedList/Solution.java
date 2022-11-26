public class Solution {
	public static void main(String[] args) {
		ListNode node = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		ListNode ans = addTwoNumbers(node, node2);
		while (ans != null) {
			System.out.print(ans.val + " -> ");
			ans = ans.next;
		}

		System.out.println();

		ListNode node3 = new ListNode(2, null);
		ListNode node4 = new ListNode(5, null);
		ListNode ans2 = addTwoNumbers(node3, node4);
		while (ans2 != null) {
			System.out.print(ans2.val + " -> ");
			ans2 = ans2.next;
		}

		System.out.println();

		ListNode node5 = new ListNode(9, null);
		ListNode node6 = new ListNode(9, null);
		ListNode ans3 = addTwoNumbers(node5, node6);
		while (ans3 != null) {
			System.out.print(ans3.val + " -> ");
			ans3 = ans3.next;
		}

		System.out.println();

		System.out.println("Testing numbers of different length:");

		ListNode node7 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode node8 = new ListNode(5, new ListNode(6, null));
		ListNode ans4 = addTwoNumbers(node7, node8);
		while (ans4 != null) {
			System.out.print(ans4.val + " -> ");
			ans4 = ans4.next;
		}
		System.out.println();
		ListNode node9 = new ListNode(9, new ListNode(9,
				new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
		ListNode node10 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
		ListNode ans5 = addTwoNumbers(node9, node10);
		while (ans5 != null) {
			System.out.print(ans5.val + " -> ");
			ans5 = ans5.next;
		}

		System.out.println();
		ListNode node11 = new ListNode(7,
				new ListNode(4,
						new ListNode(2,
								new ListNode(5,
										new ListNode(4,
												new ListNode(8,
														new ListNode(9, null)))))));
		ListNode node12 = new ListNode(9,
				new ListNode(9,
						new ListNode(9,
								new ListNode(9, new ListNode(9)))));
		ListNode ans6 = addTwoNumbers(node11, node12);
		while (ans6 != null) {
			System.out.print(ans6.val + " -> ");
			ans6 = ans6.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newNode = new ListNode(0, null);
		ListNode first = newNode;

		while (l1 != null || l2 != null) {
			int ans = 0;
			if (l1 != null && l2 != null) {
				ans = l1.val + l2.val + newNode.val;
			} else if (l1 != null) {
				ans = l1.val + newNode.val;
			} else {
				ans = l2.val + newNode.val;
			}
			int unit = ans % 10;
			newNode.val = unit;
			ans -= unit;
			ans /= 10;
			l1 = l1 == null ? l1 : l1.next;
			l2 = l2 == null ? l2 : l2.next;
			if (l1 == null && l2 == null) {
				if (ans != 0) {
					newNode.next = new ListNode(ans, null);
				}
				return first;
			}
			newNode.next = new ListNode(ans, null);
			newNode = newNode.next;

		}

		return first;
	}

}
