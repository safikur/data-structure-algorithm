package ds.arrays;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] {-7,-4,-2,-1,4,5,6};
		int[] ans = sortedSquares(arr);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+",");
		}
		
	}
	
//	Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
	
	// brute force
	public static int[] sortedSquares1(int[] A) {
        // sort
        int n=A.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=A[i]*A[i];
        }
		sort(arr);
        return arr;
    }
	// O(N)
	public static int[] sortedSquares(int[] A) {
        // sort
        int n=A.length, start=0, end=n-1, i=end;
        int[] arr = new int[n];
        
        while(i>=0) {
        	int a1 = A[start] * A[start];
        	int a2 = A[end] * A[end];
        	if(a1 >= a2) {
        		arr[i--] = a1;
        		start++;
        	} else {
        		arr[i--] = a2;
        		end--;
        	}
        }
        
        return arr;
    }
	
	
	public static void sort(int arr[]) {
		int n=arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[i]) {
					// swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
