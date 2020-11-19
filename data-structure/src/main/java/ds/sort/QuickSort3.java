package ds.sort;

public class QuickSort3 {

	public static void main(String[] args) {
		int[] arr = new int[] {7,11,10,15,1,6,4,13,2,1};
//		int[] arr = new int[] {11,10,13,15,7};
		quicksort(arr);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");

	}
	
	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		if(start<end) {
			int index = partition2(arr, start, end);
			quicksort(arr, start, index-1);
			quicksort(arr, index+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pindex=(start+end)/2;
		int pivot = arr[pindex];
		swap(arr,pindex, start);
		pindex=start;
		while(start < end) {
			while(arr[start]<=pivot)
				start++;
			while(arr[end]>pivot)
				end--;
			if(start<end)
				swap(arr, start, end);
		}
		swap(arr, pindex, end);
		return end;
	}
	
	public static int partition2(int[] arr, int start, int end) {
		int pindex=(start+end)/2;
		int pivot = arr[pindex];
		swap(arr,pindex, end);
		pindex=start;
		for(int i=start; i<end; i++) {
			if(arr[i]<=pivot)
				swap(arr, pindex++, i);
		}
		swap(arr, pindex, end);
		return pindex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
