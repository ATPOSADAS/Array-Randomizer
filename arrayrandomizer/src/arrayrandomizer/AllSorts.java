package arrayrandomizer;


import static java.lang.System.*;

import java.util.Arrays;

public class AllSorts {

	private static int[] bubble = {7, 5, 2, 4, 3, 9};
	private static int[] insertion = {29, 20, 73, 34, 64};
	private static int[] selection = {29, 64, 73, 34, 20};
	private static int[] merge = {27, 10, 12, 25, 34, 16, 15, 31};
	private static int[] shell;
	private static int[] quick;
	
	//ok 
	private static int[] heap;
	private static int count;
	

	public void bubbleSort(Integer[] integers)
	{
	   for (int i = (integers.length - 1); i >= 0; i--)
	   {
	      for (int j = 1; j <= i; j++)
	      {
	         if (integers[j-1] > integers[j])
	         {
	              int temp = integers[j-1];
	              integers[j-1] = integers[j];
	              integers[j] = temp;
	              count++;
	         } 
	      }
	   }
	}
	//bubble merge quick insertion selection shelf heap
	
	public void insertionSort(Integer[] integers) {
	    for (int i = 1; i < integers.length; i++) {
	        int current = integers[i];
	        int j = i - 1;
	        while(j >= 0 && current < integers[j]) {
	            integers[j+1] = integers[j];
	            j--;	          
	            count++;
	        }
	        // at this point we've exited, so j is either -1
	 
	        // or it's at the first element where current >= a[j]
	        integers[j+1] = current;
	    }
	}
	
	public void selectionSort(Integer[] integers) {
		for (int i = 0; i < integers.length; i++) {
	        int min = integers[i];
	        int minId = i;
	        for (int j = i+1; j < integers.length; j++) {
	            if (integers[j] < min) {
	                min = integers[j];
	                minId = j;
	            }
	        }
	        // swapping
	        if(min != integers[i] && minId != i)
	        {
	        	count++;
	        }
	        int temp = integers[i];
	        integers[i] = min;
	        integers[minId] = temp;
	        
	    }
	}

	private void merge(Integer[] integers, int l, int m, int r) {
		count++;
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = integers[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = integers[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				integers[k] = L[i];
				i++;
			} else {
				integers[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			integers[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			integers[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public void mergeSort(Integer[] integers, int l, int r) {
		
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			count++;
			mergeSort(integers, l, m);
			count++;
			mergeSort(integers, m + 1, r);
			count++;
			merge(integers, l, m, r);
			
		}
	}

	private void swap(int[] a, int one, int two) {
		int a1 = a[one];
		a[one] = a[two];
		a[two] = a1;
	}

	private boolean sorted(int arr[], int n) {

		// Array has one or no element
		if (n == 0 || n == 1)
			return true;

		for (int i = 1; i < n; i++)

			// Unsorted pair found
			if (arr[i - 1] > arr[i])
				return false;

		// No unsorted pair found
		return true;
	}
	public static void shellSort(Integer[] arr) {
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = arr[i];
				count++;
				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
	}

	private int partition(Integer[] integers, int begin, int end) {
	    int pivot = end;

	    int counter = begin;
	    for (int i = begin; i < end; i++) {
	        if (integers[i] < integers[pivot]) {
	            int temp = integers[counter];
	            integers[counter] = integers[i];
	            integers[i] = temp;
	            counter++;
	            count++;
	        }
	    }
	    int temp = integers[pivot];
	    integers[pivot] = integers[counter];
	    integers[counter] = temp;

	    return counter;
	}

	public void quickSort(Integer[] integers, int begin, int end) {
	    if (end <= begin) return;
	    int pivot = partition(integers, begin, end);
	  
	    quickSort(integers, begin, pivot-1);
	    quickSort(integers, pivot+1, end);
	}
	
	private void heapify(Integer[] integers, int length, int i) {
	    int leftChild = 2*i+1;
	    int rightChild = 2*i+2;
	    int largest = i;

	    // if the left child is larger than parent
	    if (leftChild < length && integers[leftChild] > integers[largest]) {
	        largest = leftChild;
	    }

	    // if the right child is larger than parent
	    if (rightChild < length && integers[rightChild] > integers[largest]) {
	        largest = rightChild;
	    }

	    // if a swap needs to occur
	    if (largest != i) {
	        int temp = integers[i];
	        integers[i] = integers[largest];
	        integers[largest] = temp;
	        heapify(integers, length, largest);
	    }
	}

	public void heapSort(Integer[] integers) {
	    if (integers.length == 0) return;

	    // Building the heap
	    int length = integers.length;
	    // we're going from the first non-leaf to the root
	    for (int i = length / 2-1; i >= 0; i--)
	        heapify(integers, length, i);

	    for (int i = length-1; i >= 0; i--) {
	        int temp = integers[0];
	        integers[0] = integers[i];
	        integers[i] = temp;
	        count++;
	        heapify(integers, i, 0);
	    }
	}
	
	
	public void resetCount()
	{
		System.out.println("Actual Case :: " + count);
		count = 0;
	}
}



