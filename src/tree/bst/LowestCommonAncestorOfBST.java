package tree.bst;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//time : O(h)
//space : O(h)

public class LowestCommonAncestorOfBST {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root.val > Math.max(node1.val, node2.val))
			return lowestCommonAncestor(root.left, node1, node2);
		if (root.val < Math.min(node1.val, node2.val))
			return lowestCommonAncestor(root.right, node1, node2);
		return root;
	}

//	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
//		if (root.val > Math.max(node1.val, node2.val)) {
//			System.out.println("I root.val : " + root.val + ", node1.val : " + node1.val + ", node2.val : " + node2.val);
//			return lowestCommonAncestor(root.left, node1, node2);
//		}
//
//		if (root.val < Math.min(node1.val, node2.val)) {
//			System.out.println("II root.val : " + root.val + ", node1.val : " + node1.val + ", node2.val : " + node2.val);
//			return lowestCommonAncestor(root.right, node1, node2);
//		}
//
//		System.out.println("III root.val : " + root.val + ", node1.val : " + node1.val + ", node2.val : " + node2.val);
//		return root;
//	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		int p = 2;
		TreeNode node1 = new TreeNode(p);
		int q = 8;
		TreeNode node2 = new TreeNode(q);
		TreeNode ans = lowestCommonAncestor(root, node1, node2);
		System.out.println(ans.val);

		input = new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		p = 2;
		node1 = new TreeNode(p);
		q = 4;
		node2 = new TreeNode(q);
		ans = lowestCommonAncestor(root, node1, node2);
		System.out.println(ans.val);

		input = new Integer[] { 2, 1 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		p = 2;
		node1 = new TreeNode(p);
		q = 1;
		node2 = new TreeNode(q);
		ans = lowestCommonAncestor(root, node1, node2);
		System.out.println(ans.val);

		
		input = new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		p = 3;
		node1 = new TreeNode(p);
		q = 5;
		node2 = new TreeNode(q);
		ans = lowestCommonAncestor(root, node1, node2);
		System.out.println(ans.val);

	}
}
