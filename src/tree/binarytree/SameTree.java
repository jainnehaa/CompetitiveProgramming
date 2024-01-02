package tree.binarytree;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class SameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		
		Integer[] pArr = new Integer[] { 1, 2, 3 };
		Integer[] qArr = new Integer[] { 1, 2, 3 };
		TreeNode p = ArrayToBinaryTree.arrayToBT(pArr, 0);
		TreeNode q = ArrayToBinaryTree.arrayToBT(qArr, 0);
		boolean ans = isSameTree(p, q);
		System.out.println(ans);

		pArr = new Integer[] { 1, 2, 1 };
		qArr = new Integer[] { 1, 1, 2 };
		p = ArrayToBinaryTree.arrayToBT(pArr, 0);
		q = ArrayToBinaryTree.arrayToBT(qArr, 0);
		ans = isSameTree(p, q);
		System.out.println(ans);

	}
}
