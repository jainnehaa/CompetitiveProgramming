package tree.binarytree;

import java.util.ArrayList;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class InvertBinaryTree {

	public static TreeNode invertBinaryTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = invertBinaryTree(right);
		root.right = invertBinaryTree(left);

		return root;
	}

	public static void main(String[] args) {
		Integer[] input1 = new Integer[] { 4, 2, 7, 1, null, 6, 9 };
		TreeNode root1 = ArrayToBinaryTree.arrayToBT(input1, 0);
		TreeNode invertedRoot1 = invertBinaryTree(root1);

		//bfs - ignore null in between
		ArrayToBinaryTree.bfs(invertedRoot1);
		System.out.println();
		//printing with null in between
		ArrayList<Integer> ans = ArrayToBinaryTree.printTreeAsArray(invertedRoot1);
		System.out.println(ans);
	}

}
