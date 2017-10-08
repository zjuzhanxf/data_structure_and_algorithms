// LC-320-Generalized-Abbreviation
/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

class Solution {
    public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		dfs(res, word, "", 0, 0);
		return res;
    }
	public void dfs(List<String> res, String word, String curr, int count, int pos) {
		if (pos == word.length()) {
            if (count > 0) {
                curr += count;
            }
            res.add(curr);
			return;
		}

		dfs(res, word, count==0?curr+word.charAt(pos): curr+count+word.charAt(pos), 0, pos+1);
		dfs(res, word, curr, count+1, pos+1);
	}
}