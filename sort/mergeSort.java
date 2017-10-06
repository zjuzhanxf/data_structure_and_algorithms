/* merge sort*/
class Solution {
	public void mergeSort (int[] nums ) {
		int[] aux = nums.clone();
		mergeSort(nums, 0, nums.length-1, aux);
	}

	public void mergeSort(int[] nums, int lo, int hi, int[] aux) {
		if (lo >= hi) return;
		int mid = lo + (hi-lo)/2;
		mergeSort(aux, lo, mid, nums);
		mergeSort(aux, mid+1, hi, nums);
		merge(nums, lo, mid, hi, aux);
	}

	public void merge(int[] nums, int lo, int mid, int hi, int[] aux) {
		int i = lo, j = mid+1;
		int k = lo;
		while (i <= mid && j <= hi) {
			if (aux[i] < aux[j]) {
				nums[k++] = aux[i++];
			} else {
				nums[k++] = aux[j++];
			}
		}

		while (i <= mid) {
			nums[k++] = aux[i++];
		}
		while (j <= hi) {
			nums[k++] = aux[j++];
		}
	}
}