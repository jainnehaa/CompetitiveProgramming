package tree.binarytree;

import tree.TreeNode;

//DFS
//time : O(m*n)
//space : O(h), h = height of tree = [ceil(log2(n+1)) - 1]

public class SubtreeCheck {

	public boolean isSubtree(TreeNode subTree, TreeNode tree) {

		if (subTree == null)
			return false;

		if (isSameTree(subTree, tree))
			return true;

		return isSubtree(subTree.left, tree) || isSubtree(subTree.right, tree);
	}

	private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null || tree2 == null)
			return tree1 == tree2;

		return tree1.val == tree2.val && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
	}
}
