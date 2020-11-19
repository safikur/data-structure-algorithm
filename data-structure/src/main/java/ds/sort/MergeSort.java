package ds.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4,5,15,20};
		int[] arr2 = new int[] {2,10,12,18};
//		int[] arr = new int[arr1.length+arr2.length];
//		merge(arr1, arr2, arr);
		
		int[] arr = new int[] {7,8,1,3,10,4,15};
		mergeSort(arr);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]+",");
	}
	
	public static void mergeSort(int[] arr) {
		if(arr.length<2) return;
		int mid = arr.length/2;
		int[] arr1 = new int[mid]; 
		int[] arr2 = new int[arr.length-mid];
		
		for(int i=0; i<mid;i++)
			arr1[i]=arr[i];
		for(int i=mid, k=0; i<arr.length; i++)
			arr2[k++]=arr[i];
		
		mergeSort(arr1);
		mergeSort(arr2);
		merge(arr1, arr2, arr);
	}
	
	public static int[] merge(int[] arr1, int[] arr2, int[] arr) {
		int i=0,j=0, k=0;
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<=arr2[j])
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
		}
		
		for(;i<arr1.length;i++)
			arr[k++] = arr1[i];
		
		for(;j<arr2.length;j++)
			arr[k++] = arr2[j];
		
		return arr;
	}
}
