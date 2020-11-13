package ds.sort;

public class QuickSort2 {

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
			quicksort(arr, index, end);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start]<pivot) {
				start++;
			}
			
			while(arr[end]>pivot) {
				end--;
			}
		
			if(start<=end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		
		return start;
	}
}
