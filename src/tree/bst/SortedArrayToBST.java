package tree.bst;

import java.util.List;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//Time : O(n)
//space : O(log n) - height balance bst

public class SortedArrayToBST {

	public static TreeNode sortedArrayToBST(Integer[] sortedArrObj) {
		return buildTree(sortedArrObj, 0, sortedArrObj.length - 1);
	}

	private static TreeNode buildTree(Integer[] sortedArrObj, int l, int r) {
		if (l > r)
			return null;
		int m = (l + r) / 2;
		return new TreeNode(sortedArrObj[m], buildTree(sortedArrObj, l, m - 1), buildTree(sortedArrObj, m + 1, r));
	}
	
	public static void main(String[] args) {
		Integer[] input = new Integer[] { -10, -3, 0, 5, 9};
		TreeNode root = sortedArrayToBST(input);
		
		List<Integer> result = ArrayToBinaryTree.printTreeAsArray(root);
		System.out.println(result);
		
		input = new Integer[] {1,3};
		root = sortedArrayToBST(input);
		result = ArrayToBinaryTree.printTreeAsArray(root);
		System.out.println(result);
	}
}
