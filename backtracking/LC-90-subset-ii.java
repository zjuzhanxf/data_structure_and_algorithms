class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> holder = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(res, holder, nums, 0);
		
		return res;
	}
	public void backtrack(List<List<Integer>> res, List<Integer> holder, int[] nums, int start) {
		res.add(new ArrayList<Integer>(holder));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i-1]) continue;
			holder.add(nums[i]);
			backtrack(res, holder, nums, i+1);
			holder.remove(holder.size()-1);
		}
	}
}