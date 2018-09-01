package jianzhioffer2;

public class P17_Substructureofthetree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		BinaryTreeNode root1 = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2 = new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		BinaryTreeNode node4 = new BinaryTreeNode(5);

		BinaryTreeNode root2 = new BinaryTreeNode(2);
		BinaryTreeNode node6 = new BinaryTreeNode(4);
		BinaryTreeNode node7 = new BinaryTreeNode(5);

		root1.left = node1;
		root1.right = node2;
		node1.left = node3;
		node1.right = node4;

		root2.left = node6;
		root2.right = node7;

		System.out.println(HasSubtree(root1, root2));
	}

	public static boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {

		if(root1 == null || root2 == null) {
			return false;
		}
		if(isSubtree(root1, root2)||HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2)) {
			return true;
		}
		return false;
	}

	public static boolean isSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		///root1 和root2 是否为空的判断顺序也会影响执行结果
		if(root2 == null)
            return true;
        if(root1 == null)
            return false;
		if(root1.value == root2.value) {
			return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
		}else {
			return false;
		}
	}
}
