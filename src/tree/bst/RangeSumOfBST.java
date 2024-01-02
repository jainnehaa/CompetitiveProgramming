package tree.bst;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//time : O(n)
//space : O(h), h = height of tree with n nodes

public class RangeSumOfBST {

	public static int rangeSumOfBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;

		if (root.val < L)
			return rangeSumOfBST(root.right, L, R);

		if (root.val > R)
			return rangeSumOfBST(root.left, L, R);

		return root.val + rangeSumOfBST(root.left, L, R) + rangeSumOfBST(root.right, L, R);
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 10, 5, 15, 3, 7, null, 18 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		int ansSum = rangeSumOfBST(root, 7, 15);
		System.out.println(ansSum);

		input = new Integer[] { 10,5,15,3,7,13,18,1,null,6 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		ansSum = rangeSumOfBST(root, 6, 10);
		System.out.println(ansSum);

	
	}
}
