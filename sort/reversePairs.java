public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        int[] aux = A.clone();
        return mergeSort(A, 0, A.length-1, aux);
    }


	public int mergeSort(int[] nums, int lo, int hi, int[] aux) {
		if (lo >= hi) return 0;
		int mid = lo + (hi-lo)/2;
		int sum = 0;
		sum += mergeSort(aux, lo, mid, nums);
		sum += mergeSort(aux, mid+1, hi, nums);
		sum += merge(nums, lo, mid, hi, aux);
		
		return sum;
	}

	public int merge(int[] nums, int lo, int mid, int hi, int[] aux) {
		int i = lo, j = mid+1;
		int k = lo;
		int reversePairs = 0;
		while (i <= mid && j <= hi) {
			if (aux[i] <= aux[j]) {
				nums[k++] = aux[i++];
			} else {
				nums[k++] = aux[j++];
				reversePairs += mid - i + 1;
			}
		}

		while (i <= mid) {
			nums[k++] = aux[i++];
		}
		while (j <= hi) {
			nums[k++] = aux[j++];
		}
		
		return reversePairs;
	}
}