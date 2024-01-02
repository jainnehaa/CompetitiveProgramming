package tree.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

public class InorderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			ans.add(root.val);
			root = root.right;
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Integer[] input = new Integer[] {1,null,2,null, null, 3};
		TreeNode root = ArrayToBinaryTree.arrayToBT(input, 0);
		System.out.println(ArrayToBinaryTree.printTreeAsArray(root));
		
		List<Integer> ans = inorderTraversal(root);
		System.out.println(ans);
	}
}