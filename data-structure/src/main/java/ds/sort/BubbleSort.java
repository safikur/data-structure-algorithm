package ds.sort;

public class BubbleSort {

	public static void main(String[] args) {
//		int[] arr = new int[] {15,10,9,7,5,4,3,2,1};
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		bubbleSort(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+",");
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			boolean flag = false;
			System.out.println("i:"+i);
			for(int j=0; j<arr.length-1-i; j++) {
				System.out.println("j:"+j);
				if(arr[j]>arr[j+1]) {
					// swap(arr[j], arr[j+1]);
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}
}
