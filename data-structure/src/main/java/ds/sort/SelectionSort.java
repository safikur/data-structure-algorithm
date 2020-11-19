package ds.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {7,8,1,3,10,4,15};
		selectionSort(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");
	}
	
	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-2; i++) {
			int min=i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			
			// swap(arr[j], arr[i]);
			int temp =arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}
}
