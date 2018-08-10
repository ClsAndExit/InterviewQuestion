package jiazhioffer2;

import java.net.URI;

public class ReverseLinkList {

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

		printLinkList(ReverseList(head));
	}

	public static ListNode ReverseList(ListNode head) {

		ListNode pNode =  null;
		ListNode nextNode = new ListNode(1);
		while (head != null) {
			nextNode = head.next;
			head.next = pNode;
			pNode = head;
			head = nextNode;
		}
		return pNode;
	}

//		public static ListNode ReverseList(ListNode head) {
//
//		ListNode pNode =  head;
//		ListNode r = pNode;
//		head = head.next;
//
//		pNode.next = null;
//		while (head != null) {
//			r= head;
//			r.next = pNode;
//			pNode = r;
//			head = head.next;
//		}
//		return pNode;
//	}

	public static void printLinkList(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
