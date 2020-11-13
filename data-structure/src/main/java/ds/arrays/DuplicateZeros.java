package ds.arrays;

public class DuplicateZeros {

	public static void main(String[] args) {
		int[] arr =  new int[] {0,1,1,1};
		duplicateZeros(arr);
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]+",");
	}
	
	public static void duplicateZeros(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				for(int j=arr.length-1; j>i; j--) {
					arr[j]=arr[j-1];
				}
				i++;
			}
		}
	}
	
	public static void duplicateZeros1(int[] arr) {
		int prev=-1;
		for(int i=0; i<arr.length; i++) {
			if(prev==0) {
				
			}else {
				//swap temp with current
				int temp = arr[i];
				arr[i] = prev;
				prev = temp;
				
			}
		}
	}
}
