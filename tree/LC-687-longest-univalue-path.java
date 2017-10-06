// LC-687-longest-univalue-path

class Solution {
	int longest;
	public int longestUnivaluePath(TreeNode root) {
	  if (root == null) {
	    return 0;
	  }
	  helper(root, root.val);
	  return longest;
	}

	public int helper(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left, node.val);
		int right = helper(node.right, node.val);

		longest = Math.max(longest, left + right);
		if (node.val == val) {
			return 1 + Math.max(left, right);
		}
		return 0;
	}

}