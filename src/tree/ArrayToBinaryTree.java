package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.lang3.ArrayUtils;

//time : O(n)
//space : O(n) - for call stack in worst case of linear tree - unbalanced one 

public class ArrayToBinaryTree {

	//it does not consider input with -1 as null for int[]
	public static TreeNode arrayToBT(int[] arr, int index) {
		Integer[] arrObj = ArrayUtils.toObject(arr);
		return arrayToBT(arrObj, index);
	}

	public static TreeNode arrayToBT(Integer[] arrObj, int index) {
		TreeNode root = null;

		if (index < arrObj.length) {
			if (arrObj[index] == null)
				return null;

			root = new TreeNode(arrObj[index]);
			root.left = arrayToBT(arrObj, (2 * index + 1));
			root.right = arrayToBT(arrObj, (2 * index + 2));
		}

		return root;
	}

	public static void printBinaryTreePreOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			printBinaryTreePreOrder(root.left);
			printBinaryTreePreOrder(root.right);
		}
	}

	public static ArrayList printBinaryTreePreOrderWithNulls(TreeNode root, ArrayList<Integer> result) {
		if (root != null) {
			result.add(root.val);
			if(root.left != null)
				printBinaryTreePreOrderWithNulls(root.left, result);	
			if(root.right != null)
				printBinaryTreePreOrderWithNulls(root.right, result);
		} else {
			result.add(null);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		Integer[] arrObj = new Integer[] { 10, 20, 30, 40, null, 50, 60, 70 };

		TreeNode root1 = arrayToBT(arr, 0);
		System.out.print("print (Root-Left-Right) : ");
		printBinaryTreePreOrder(root1);

		TreeNode root2 = arrayToBT(arrObj, 0);
		System.out.print("\nprint (Root-Left-Right) : ");
		printBinaryTreePreOrder(root2);
		
		Integer[] arrObj1 = new Integer[] { 10, 20, 30, 40, null, 50, 60 };
		TreeNode root3 = arrayToBT(arrObj1, 0);
		System.out.print("\nprint with nulls (Root-Left-Right) : ");
		ArrayList<Integer> result = printBinaryTreePreOrderWithNulls(root3, new ArrayList());
		System.out.println(result);
	}

	public static void bfs(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			System.out.print(node.val + " ");

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static ArrayList<Integer> printTreeAsArray(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current != null) {
				result.add(current.val);
				queue.add(current.left);
				queue.add(current.right);
			} else {
				result.add(null);
			}
		}

		// Trim any trailing nulls
		int i = result.size() - 1;
		while (i >= 0 && result.get(i) == null) {
			result.remove(i);
			i--;
		}

		return result;
	}
}
