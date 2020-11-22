package ds.linkedlist;

public class ReverseBetween {

	public static void main(String[] args) {
//		ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));
		ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
		printNodes(l2);
		
		System.out.println();
		printNodes(reverseBetween(l2, 1, 3));
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode nodem = null;
        ListNode noden = null;
        ListNode prev = null;
        ListNode next = null;
        ListNode pause = null;
        int pos = 1;
        
        while(cur != null && pos<=n){
        	next = cur.next;
        	
        	if(m==pos){
                pause = prev;
                nodem = cur;
            }
        	if(n==pos) {
        		noden = cur;
        	}
        	
        	if(m<pos && pos<=n){
                cur.next = prev;
            }
            
            prev=cur;
            cur = next;
            pos++;
        }
        
        nodem.next = cur;
        
        if(pause==null)
        	head = noden;
        else
        	pause.next = noden;
        
        return head;
    }
	
	private static void printNodes(ListNode r) {
		do {
			System.out.print(r.val+"->");
			r=r.next;
		} while (r!=null);
		
	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
