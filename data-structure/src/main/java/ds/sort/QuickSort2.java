package ds.sort;

public class QuickSort2 {

	public static void main(String[] args) {
		int[] arr = new int[] {11,10,15,1,6,4,13,2,8};
//		int[] arr = new int[] {15,10,2,11,8};
		quicksort(arr);
		print(arr, 0, arr.length);
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
	
	private static void print(int[] arr, int start, int end) {
		for(; start<end; start++)
			System.out.print(arr[start]+",");
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
	
	public static int partition1(int[] arr, int start, int end) {
		int mid = (start+end)/2;
		int pivot = arr[mid];
		while(start<end) {
			while(arr[start]<pivot || start==mid) {
				start++;
			}
			
			while(arr[end]>pivot || end==mid) {
				end--;
			}
		
			if(start<end) {
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		if(start<=end)
			swap(arr,start,mid);
		
		return start;
	}
}
