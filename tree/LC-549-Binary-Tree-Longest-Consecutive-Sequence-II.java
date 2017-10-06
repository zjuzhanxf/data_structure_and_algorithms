class Solution {
    int longest = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{0,0};
        
        int inc = 1;
        int dec = 1;
        if (root.left != null) {
            int[] l = helper(root.left);
            if(root.val + 1 == root.left.val) {
                inc = l[0] + 1;
            } else if (root.val - 1 == root.left.val) {
                dec = l[1] + 1;
            }
        }
        
        if (root.right != null) {
            int[] r = helper(root.right);
            if (root.val + 1 == root.right.val) {
                inc = Math.max(inc, r[0] + 1);
            } else if (root.val - 1 == root.right.val) {
                dec = Math.max(dec, r[1] + 1);
            }
        }
        longest = Math.max(longest, inc+dec-1);
        return new int[]{inc, dec};
    }
}