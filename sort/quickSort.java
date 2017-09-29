class Ideone
{
   public void quicksort (int[] A, int lo, int hi ) {
	 if ( lo < hi ) {
	     int p = partition(A, lo, hi);
	     quicksort(A, lo, p-1);
	     quicksort(A, p+1, hi);
	 }
   }
 
   public int partition(int[] A, int lo, int hi) {
   	int i = lo - 1, pivot = A[hi];
	for (int j = lo; j < hi; j++) {
          if (A[j] <= pivot) {
		   i++;
	         swap(A, i, j);
          }
      }
 
      swap(A, i+1, hi);
      return i+1;
    }
 
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone obj = new Ideone();
		int[] array = {4, 5, 6, 2, 8, 7, 1, 5, 9, 0, 3};
		int n = array.length;
		obj.quicksort(array, 0, n-1);
		for (int item : array) {
			System.out.print(item + " ");
		}
 
	}
}