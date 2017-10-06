// O(N)
class Solution {
	int longest;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }

    public int helper(TreeNode root) {
    	if (root == null) return 0;
    	int left = helper(root.left) + 1;
    	int right = helper(root.right) + 1;

    	if (root.left != null && root.val+1 != root.left.val) {
    		left = 1;
    	}
    	if (root.right != null && root.val+1 != root.right.val) {
    		right = 1;
    	}

    	int length = Math.max(left, right);
    	longest = Math.max(length, longest);

    	return length;
    }
}