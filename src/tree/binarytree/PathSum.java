package tree.binarytree;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class PathSum {

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) // empty tree
			return false;
		if (root.val == targetSum && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		int targetSum = 22;
		boolean ans = hasPathSum(root, targetSum);
		System.out.println(ans);
		
		input = new Integer[] { 1,2,3 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		targetSum = 5;
		ans = hasPathSum(root, targetSum);
		System.out.println(ans);
		
		input = new Integer[] { };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		targetSum = 0;
		ans = hasPathSum(root, targetSum);
		System.out.println(ans);
	}
}
