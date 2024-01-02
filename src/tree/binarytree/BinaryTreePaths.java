package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//time : O(n)
//space : O(h), h = height of n nodes

public class BinaryTreePaths {

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new ArrayList<>();
		binaryTreePaths(root, new StringBuilder(), ans);
		return ans;
	}

	private static void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> ans) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			ans.add(sb.append(root.val).toString());
			return;
		}
		int len = sb.length();
		binaryTreePaths(root.left, sb.append(root.val).append("->"), ans);
		sb.setLength(len);
		binaryTreePaths(root.right, sb.append(root.val).append("->"), ans);
		sb.setLength(len);
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 1, 2, 3, null, 5 };
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		List<String> ans = binaryTreePaths(root);
		System.out.println(ans);

		input = new Integer[] { 1 };
		root = ArrayToBinaryTree.arrayToBT(input, 0);
		ans = binaryTreePaths(root);
		System.out.println(ans);
	}
}
