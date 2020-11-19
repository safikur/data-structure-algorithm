package ds.stack;

public class StackLinkedList {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(5);
		stack.push(15);
		stack.push(12);
		stack.push(1);
		stack.push(8);
		
		System.out.println(stack.data.length);
		System.out.println(stack.top);
		System.out.println(stack.top());
		stack.print();
		
		for(int i=0; i<100; i++) {
			stack.push(i);
		}
		
		stack.print();
//		System.out.println("top->"+stack.top());
//		stack.print();
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
//		stack.print();
		System.out.println(stack.data.length);
	}
	
	private static class Stack {
		private static final int MIN_SIZE=5;
		private int[] data = new int[MIN_SIZE];
		int top =-1;
		
		public void push(int data) {
			checkSize();
			this.data[++top]=data;
		}
		private void checkSize() {
			if(top+1>=data.length) {
				grow();
			}
			
		}
		private void grow() {
			int[] newArr = new int[data.length * 2];
			copy(data, newArr);
			
		}
		private void copy(int[] arr1, int[] arr2) {
			for(int i=0; i<arr1.length; i++)
				arr2[i]=arr1[i];
			this.data=arr2;
		}
		public int pop() throws Exception {
			if(top== -1) {
				throw new Exception("Stack is empty");
			} else {
				return data[top--];
			}
		}
		public int top() throws Exception {
			if(top== -1)
				throw new Exception("Stack is empty");
			else
				return data[top];
		}
		public void print() {
			for(int i=0; i<top; i++)
				System.out.print("<-"+data[i]);
			System.out.println();
		}
	}
}
