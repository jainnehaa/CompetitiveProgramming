package tree.binarytree;

import java.util.List;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class MergeTwoBinaryTrees {

	public static TreeNode mergeBT(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return null;

		int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);

		TreeNode root = new TreeNode(val);

		root.left = mergeBT(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
		root.right = mergeBT(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

		return root;
	}

	public static void main(String[] args) {
		Integer[] input1 = new Integer[] { 1, 3, 2, 5 };
		TreeNode root1 = ArrayToBinaryTree.arrayToBT(input1, 0);
		Integer[] input2 = new Integer[] { 2, 1, 3, null, 4, null, 7 };
		TreeNode root2 = ArrayToBinaryTree.arrayToBT(input2, 0);
		TreeNode root = mergeBT(root1, root2);
		List<Integer> result = ArrayToBinaryTree.printTreeAsArray(root);
		System.out.println(result);

		input1 = new Integer[] { 1 };
		root1 = ArrayToBinaryTree.arrayToBT(input1, 0);
		input2 = new Integer[] { 1, 2 };
		root2 = ArrayToBinaryTree.arrayToBT(input2, 0);
		root = mergeBT(root1, root2);
		result = ArrayToBinaryTree.printTreeAsArray(root);
		System.out.println(result);
	}
}
