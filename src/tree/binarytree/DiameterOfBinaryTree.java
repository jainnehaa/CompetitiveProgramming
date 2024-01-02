package tree.binarytree;

import tree.ArrayToBinaryTree;
import tree.TreeNode;

//time : O(n)
//space : o(h)
//h = (ceil(log2(n+1))-1)
//max h could be (n-1) - unbalanced BT
public class DiameterOfBinaryTree {

	private static int ans = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int l = diameterOfBinaryTree(root.left);
		int r = diameterOfBinaryTree(root.right);
		ans = Math.max(ans, (l + r));
		return 1 + Math.max(l, r);
	}

	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5 };
		int[] input2 = { 10, 20 };

		//with negative and -1 as null
		TreeNode root1 = ArrayToBinaryTree.arrayToBT(input1, 0);
		//with negative and -1 as null
		TreeNode root2 = ArrayToBinaryTree.arrayToBT(input2, 0);

		diameterOfBinaryTree(root1);
		System.out.println(ans);
		ans = 0;
		diameterOfBinaryTree(root2);
		System.out.println(ans);
	}
}
