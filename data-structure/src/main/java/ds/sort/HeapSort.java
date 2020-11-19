package ds.sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = new int[] {7,11,10,15,1,6,4,13,2,1};
		
		heapSort(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");
	}
	
	public static void heapSort(int[] arr) {
		int n=arr.length;
		// create a Maxheap; find out first non-leaf element and heapify all the elements from there.
		for(int i=n/2-1; i>=0; i--)
			maxHeapify(arr, n, i);
		
		// remove root from Heap
		for(int i=n-1; i>0; i--) {
			remove(arr, i, 0);
		}
	}
	
	public static void remove(int[] arr, int size, int index) {
		// move the last element as root and heapify
		swap(arr,size,0);
		
		// heapify after removal
		maxHeapify(arr,size,0);
	}
	
	// re arrange to build a Max Heap. Heapify the element in index position in the array arr with heap size =n
	public static void maxHeapify(int[] arr, int size, int root) {
		int max = root;
		int left = 2*root+1;
		int right = 2*root+2;
		
		if(left < size && arr[left] > arr[max])
			max = left;
		
		if(right < size && arr[right] > arr[max])
			max = right;
		
		if(max != root) {
			swap(arr, root, max);
			maxHeapify(arr, size, max);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
