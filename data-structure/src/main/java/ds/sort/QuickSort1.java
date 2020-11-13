package ds.sort;

public class QuickSort1 {

	public static void main(String[] args) {
		int[] arr = new int[] {11,10,15,1,6,4,13,2,1};
		quicksort(arr);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");

	}
	
	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		if(start<end) {
			int index = partition(arr, start, end);
			quicksort(arr, start, index-1);
			quicksort(arr, index+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int index=start;
		int pivot = arr[end];
		for(int i=start; i<end; i++) {
			if(arr[i]<=pivot) {
				swap(arr,i,index);
				index++;
			}
		}
		swap(arr, index, end);
		return index;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
