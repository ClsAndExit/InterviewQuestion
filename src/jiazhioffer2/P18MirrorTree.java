package jiazhioffer2;

public class P18MirrorTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BinaryTreeNode root1 = new BinaryTreeNode(6);
		BinaryTreeNode node1 = new BinaryTreeNode(8);
		BinaryTreeNode node2 = new BinaryTreeNode(10);
		BinaryTreeNode node3 = new BinaryTreeNode(5);
		BinaryTreeNode node4 = new BinaryTreeNode(7);
		BinaryTreeNode node5 = new BinaryTreeNode(9);
		BinaryTreeNode node6 = new BinaryTreeNode(11);

		// root1.left = node1;
		// root1.right = node2;
		// node1.left = node3;
		// node1.right = node4;
		// node2.left = node5;
		// node2.right = node6;
		root1.right = node1;
		node1.right = node2;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;
		node5.right = node6;

		printTree(root1);
		System.out.println("After Mirrot");
		printTree(Mirror(root1));
	}

	/// 求鏡像
	public static BinaryTreeNode Mirror(BinaryTreeNode root) {
		BinaryTreeNode temp = new BinaryTreeNode(0);
		// if (root.left != null && root.right != null) {
		// temp = root.left;
		// root.left = root.right;
		// root.right = temp;
		// Mirror(root.left);
		// Mirror(root.right);
		// } else if (root.left == null && root.right != null) {
		// //temp = root.left;
		// root.left = root.right;
		// root.right = null;
		// Mirror(root.left);
		// } else if (root.left != null && root.right == null) {
		// temp = root.left;
		// root.left = null;
		// root.right = temp;
		// Mirror(root.right);
		// }else if (root.left == null && root.right == null) {
		//
		// }
		if (root != null) {
			temp = root.left;
			root.left = root.right;
			root.right = temp;
			if(root.left!=null) {
				Mirror(root.left);
			}
			if (root.right!=null) {
				Mirror(root.right);
			}
		}
		return root;
	}

	// 前序遍历递归打印
	public static void printTree(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			printTree(node.left);
			printTree(node.right);
		}
	}

}
