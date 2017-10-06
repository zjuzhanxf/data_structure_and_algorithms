class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        helper(res, holder, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> holder, int[] nums) {
        if (holder.size() == nums.length) {
            res.add(new ArrayList<Integer>(holder));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!holder.contains(nums[i])) {
                holder.add(nums[i]);
                helper(res, holder, nums);
                holder.remove(holder.size()-1);
            }
        }
    }
}