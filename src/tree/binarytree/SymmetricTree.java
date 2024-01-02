package tree.binarytree;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class SymmetricTree {

	public static boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private static boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;

		return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 1, 2, 2, 3, 4, 4, 3 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		boolean ans = isSymmetric(root);

		System.out.println(ans);

		input = new Integer[] { 1, 2, 2, null, 3, null, 3 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		ans = isSymmetric(root);
		
		System.out.println(ans);
	}
}
