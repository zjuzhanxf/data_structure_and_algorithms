class Solution {
	public List<List<Integer>> combinationSumWithDup(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> holder = new ArrayList<>();
		findCombSum(res, holder, nums, target, 0);
		return res;
	}

	public void findCombSum(List<List<Integer>> res, List<Integer> holder, int[] nums, int target, int start) {
		if (target < 0) return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(holder));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i-1]) continue;
			if (nums[i] <= target) {
				holder.add(nums[i]);
				findCombSum(res, holder, nums, target-nums[i], i+1);
				holder.remove(holder.size()-1);
			}
		}
	}
}