class Solution {
    public List<List<Integer>> permuteWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(res, holder, nums, used);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> holder, int[] nums, boolean[] used) {
        if (holder.size() == nums.length) {
            res.add(new ArrayList<Integer>(holder));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            holder.add(nums[i]);

            helper(res, holder, nums, used);

            used[i] = false;
            holder.remove(holder.size()-1);
            
        }
    }
}