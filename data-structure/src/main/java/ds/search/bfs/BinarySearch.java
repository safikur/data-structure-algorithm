package ds.search.bfs;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {-12,-3,-1,0,2,5,7,8,9,11,15,20,30};
		int pos = search(-7, arr);
		System.out.println(pos);
		
		pos = linearSearch(-7, arr);
		System.out.println(pos);
		
	}
	
	public static int search(int num, int[] arr) {
		System.out.println("--Binary Search--");
		int left=0, right=arr.length-1;
		int i=0;
		while(left<=right) {
			System.out.println("i=" + i++);
			int mid = (left+right)/2;
			if(num==arr[mid])
				return mid;
			else if(num<arr[mid])
				right = mid-1;
			else
				left = mid+1;
		}
		return -1;
	}
	
	public static int linearSearch(int num, int[] arr) {
		System.out.println("--Linera Search--");
		for(int i=0; i<arr.length; i++) {
			System.out.println("i="+i);
			if(num==arr[i])
				return i;
		}
		
		return -1;
	}
}

