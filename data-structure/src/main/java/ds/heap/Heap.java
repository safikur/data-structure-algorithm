package ds.heap;

public class Heap {
	
	private int[] data;
	private int length;
	private boolean asc = true;
	 
	public static void main(String[] args) {
		int[] arr = new int[] {7,11,10,15,1,6,4,13,2,1,-1};
		
		Heap heap = new Heap();
		heap.createHeap(arr);
		heap.insert(40);
		heap.insert(50);
		
		heap.printHeap();
		
		heap.remove();
		heap.remove();
		
		heap.printHeap();
		heap.printDeleted();
		
		heap.sort(arr);
		heap.printHeap();
		heap.printDeleted();
		
		heap.sortDesc(arr);
		heap.printHeap();
		heap.printDeleted();
	}
	
	public void printHeap() {
		System.out.println("Heap");
		for(int i=0; i<length; i++)
			System.out.print(data[i]+",");
		
		System.out.println();
		System.out.println("-------------------------------------");
	}
	
	public void printDeleted() {
		System.out.println();
		System.out.println("Removed elements");
		for(int i=length; i<data.length; i++)
			System.out.print(data[i]+",");
		
		System.out.println();
		System.out.println("-------------------------------------");
	}
	
	public void createHeap(int[] arr) {
		data=arr;
		length=arr.length;
	}
	
	public void sort(int [] arr) {
		// create the Heap
		createHeap(arr);
		
		// adjust all elements in the Heap to create Max Heap
		adjustUpwards();
		
		// delete all elements from Heap
		while(length > 0)
			remove();
		
	}
	
	public void sortDesc(int [] arr) {
		asc = false;
		sort(arr);		
	}
	
	// re arrange to build a Max Heap. Heapify the element in index position in the array arr with heap size =n
	public void maxHeapify(int root) {
		int max = root;
		int left = 2*root+1;
		int right = 2*root+2;
		
		if(left < length && data[left] > data[max])
			max = left;
		
		if(right < length && data[right] > data[max])
			max = right;
		
		if(max != root) {
			swap(data, root, max);
			maxHeapify(max);
		}
	}
	
	// re arrange to build a Min Heap. Heapify the element in index position in the array arr with heap size =n
	public void minHeapify(int root) {
		int min = root;
		int left = 2*root+1;
		int right = 2*root+2;
		
		if(left < length && data[left] < data[min])
			min = left;
		
		if(right < length && data[right] < data[min])
			min = right;
		
		if(min != root) {
			swap(data, root, min);
			minHeapify(min);
		}
	}
	
	public void remove() {
		length--;
		
		// always remove element from root
		swap(data, length, 0);
		
		// then heapify to re-arrange the elements to maintain a Heap
		if(asc)
			maxHeapify(0);
		else
			minHeapify(0);
	}
	
	public void insert(int val) {
		checkSize();
		data[length++]=val;
		
		// heapify
		adjustUpwards();
		
	}
	
	private void adjustUpwards() {
		// first non leaf node :- n/2-1. Heapify all non-leaf nodes
		for(int i= length/2-1; i>=0; i--)
			if(asc)
				maxHeapify(i);
			else
				minHeapify(i);
	}
	
	private void checkSize() {
		if(length+1 > data.length)
			grow();
	}
	
	private void grow() {
		int[] newArr = new int[data.length*2];
		copy(data, newArr);
		data=newArr;
	}
	
	private void copy(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++)
			arr2[i] = arr1[i];
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
