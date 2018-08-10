package jiazhioffer2;

import java.util.Arrays;

public class ReConstructBinaryTree {

	public static void main(String[] args) {
		int[] preSort = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inSort = { 4, 7, 2, 1, 5, 3, 8, 6 };
		try {
			//BinaryTreeNode root = reConstruct(preSort, inSort);
			BinaryTreeNode root = constructCore(preSort,inSort);
			printTree(root);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static BinaryTreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
		if (preorder == null || inorder == null) {
			return null;
		}
		if (preorder.length != inorder.length) {
			throw new Exception("长度不一样，非法的输入");
		}
		BinaryTreeNode root = new BinaryTreeNode();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				root.value = inorder[i];
				//System.out.println(root.value);
				root.left= constructCore(Arrays.copyOfRange(preorder, 1, i + 1),
						Arrays.copyOfRange(inorder, 0, i));
				root.right = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length),
						Arrays.copyOfRange(inorder, i + 1, inorder.length));
			}
		}
		return root;
	}

	/**
	 * 判断输入合法性
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @return
	 */
	public static BinaryTreeNode reConstruct(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1)
			return null;
		return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	/**
	 * 根据前序遍历和中序遍历构建二叉树
	 * 
	 * @param preOrder
	 *            前序遍历序列
	 * @param ps
	 *            前序遍历开始位置
	 * @param pe
	 *            前序遍历结束位置
	 * @param inOrder
	 *            中序遍历序列
	 * @param is
	 *            中序遍历开始位置
	 * @param ie
	 *            中序遍历结束位置
	 * @return 构建的树的根节点
	 */
	public static BinaryTreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
		// 开始位置大于结束位置说明已经处理到叶节点了
		if (ps > pe)
			return null;
		/// 前序遍历第一个数字为当前的根节点
		int value = preOrder[ps];
		// index为根节点在中序遍历序列中的索引
		int index = is;
		while (index <= ie && inOrder[index] != value) {
			index++;
		}
		System.out.println("当前各参数的数值为->ps:" + ps + " pe:" + pe + " is：" + is + " ie：" + ie + " index：" + index
				+ " rootValue：" + value);
		// 如果在整个中序遍历中没有找到根节点说明输入的数据是不合法的
		if (index > ie) {
			throw new RuntimeException("invalid input" + index);
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.value = value;
		// 当前节点的左子树的个数为index-is
		// 左子树对应的前序遍历的位置在preOrder[ps+1,ps+index-is]
		// 左子树对应的中序遍历的位置在inOrder[is,index-1]
		node.left = construct(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
		// 当前节点的右子树的个数为ie-index
		// 右子树对应的前序遍历位置在preOrder[ps+index-is+1,pe]
		// 右子树对应的中序遍历位置在inOrder[index+1,ie]
		node.right = construct(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);
		return node;
	}

	// 中序遍历递归打印
	public static void printTree(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			printTree(node.left);
			
			printTree(node.right);
		}
	}
}
