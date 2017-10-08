// LC-131-Palindrome-Partitioning

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> holder = new ArrayList<>();
		dfs(res, holder, s, 0);
		return res;
	}

	public void dfs(List<List<String>> res, List<String> holder, String str, int start) {
		if (start == str.length()) {
			res.add(new ArrayList<String>(holder));
			return;
		}
		for (int i = start; i < str.length(); i++) {
			if (isPalindrome(str, start, i)) {
				holder.add(str.substring(start, i+1));
				dfs(res, holder, str, i+1);
				holder.remove(holder.size()-1);
			}
		}
	}

	public boolean isPalindrome(String str, int i, int j) {
		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}