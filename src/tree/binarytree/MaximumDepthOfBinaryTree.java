package tree.binarytree;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//time : O(n)
//space : O(1)

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		int ans = maxDepth(root);
		System.out.println(ans);

		input = new Integer[] { 1, null, 2 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		ans = maxDepth(root);
		System.out.println(ans);

	}

}
