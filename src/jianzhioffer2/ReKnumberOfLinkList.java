package jianzhioffer2;

public class ReKnumberOfLinkList {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		int value = FindKthToTail(head, 7).val;

		System.out.println(value);

	}

	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int index = 1;
		ListNode head2 = head;
		while (head.next != null) {
			head = head.next;
			index++;
		}
		if (index < k) {
			return null;
		} else {
			while (index - k > 0) {
				head2 = head2.next;
				index--;
			}
		}

		return head2;
	}
}
