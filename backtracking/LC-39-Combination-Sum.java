class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        // Arrays.sort(candidates);
        findCombSum(res, holder, candidates, target, 0);
        return res;
    }
    
    public void findCombSum(List<List<Integer>> res, List<Integer> holder, int[] nums, int target, int start) {
        if (target < 0){
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(holder));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            holder.add(nums[i]);
            findCombSum(res, holder, nums, target-nums[i], i);
            holder.remove(holder.size()-1);
        }
    }
}