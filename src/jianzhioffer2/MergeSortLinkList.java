package jianzhioffer2;

public class MergeSortLinkList {
	public static void main(String [] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode head2 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		head.next = node2;
		node2.next = node3;
		
		head2.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		printLinkList(Merge(head,head2));
		
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
		ListNode mergeNode = null;
		if(list1==null) {
			return list2;
		}
		if(list2==null) {
			return list1;
		}
		if(list1.val<list2.val) {
			mergeNode = list1;
			mergeNode.next = Merge(list1.next, list2);
		}else {
			mergeNode = list2;
			mergeNode.next = Merge(list1, list2.next);
		}
		return mergeNode;
    }
	
	public static void printLinkList(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
