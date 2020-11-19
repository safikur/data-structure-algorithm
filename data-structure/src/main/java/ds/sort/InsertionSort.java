package ds.sort;

public class InsertionSort {
	public static void main(String[] args) {
//		int[] arr = new int[] {15,10,9,7,5,4,3,2,1};
//		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] arr = new int[] {15,10,12,1,5,9,4,2,50};
		insertionSort(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");
	}
	
	public static void insertionSort(int[] arr){
		for(int i=1; i<arr.length; i++) {
			int val = arr[i];
			int pos = i;
			while(pos>0 && arr[pos-1]>val) {
				arr[pos]=arr[--pos];
			}
			arr[pos]=val;
		}
	}
}
