package dsa;


	 public class LinkedListSort {
	    static class ListNode {
	        int val;
	        ListNode next;
	        ListNode(int val) {
	            this.val = val;
	            this.next = null;
	        }
	    }

	    // Function to sort a linked list of 0s, 1s, and 2s
	    public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head; // No need to sort if list is empty or contains only one element
	        }

	        // Create three dummy nodes for 0s, 1s, and 2s
	        ListNode zeroHead = new ListNode(0);
	        ListNode oneHead = new ListNode(0);
	        ListNode twoHead = new ListNode(0);
	        
	        // These are pointers to the current node of each of the three lists
	        ListNode zero = zeroHead, one = oneHead, two = twoHead;
	        
	        // Traverse the original linked list and categorize nodes
	        ListNode current = head;
	        while (current != null) {
	            if (current.val == 0) {
	                zero.next = current;
	                zero = zero.next;
	            } else if (current.val == 1) {
	                one.next = current;
	                one = one.next;
	            } else if (current.val == 2) {
	                two.next = current;
	                two = two.next;
	            }
	            current = current.next;
	        }

	        // Connect the three lists: zero -> one -> two
	        zero.next = oneHead.next;
	        one.next = twoHead.next;
	        two.next = null; // Terminate the list to avoid cycle

	        // Return the sorted list starting from the next node of zeroHead (skipping the dummy node)
	        return zeroHead.next;
	    }

	    // Helper function to print the linked list
	    public void printList(ListNode head) {
	        ListNode current = head;
	        while (current != null) {
	            System.out.print(current.val + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    // Helper function to create a linked list from an array of values
	    public ListNode createList(int[] values) {
	        if (values.length == 0) return null;
	        ListNode head = new ListNode(values[0]);
	        ListNode current = head;
	        for (int i = 1; i < values.length; i++) {
	            current.next = new ListNode(values[i]);
	            current = current.next;
	        }
	        return head;
	    }

	    public static void main(String[] args) {
	        LinkedListSort solution = new LinkedListSort();

	        // Create a linked list of 0s, 1s, and 2s
	        int[] values = {1, 0, 2, 1, 0, 2, 1, 0};
	        ListNode head = solution.createList(values);

	        // Print the original linked list
	        System.out.println("Original List:");
	        solution.printList(head);

	        // Sort the linked list
	        ListNode sortedHead = solution.sortList(head);

	        // Print the sorted linked list
	        System.out.println("Sorted List:");
	        solution.printList(sortedHead);
	    }
	}


