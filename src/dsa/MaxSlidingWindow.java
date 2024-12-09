package dsa;


	import java.util.*;

	public class MaxSlidingWindow {

	    // Function to find maximum for each contiguous subarray of size k
	    public static int[] maxSlidingWindow(int[] nums, int k) {
	        if (nums == null || nums.length == 0 || k == 0) {
	            return new int[0];
	        }

	        // Deque to store indices of elements in the current window
	        Deque<Integer> deque = new LinkedList<>();
	        int n = nums.length;
	        int[] result = new int[n - k + 1]; // Result array to store the max of each window
	        
	        for (int i = 0; i < n; i++) {
	            // Remove elements from deque that are out of the current window
	            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
	                deque.pollFirst();
	            }

	            // Remove all elements from deque that are smaller than the current element
	            // because they are no longer needed for future windows
	            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
	                deque.pollLast();
	            }

	            // Add current element's index to the deque
	            deque.offerLast(i);

	            // Once we have processed at least k elements, the first element in deque is the max
	            if (i >= k - 1) {
	                result[i - k + 1] = nums[deque.peekFirst()];
	            }
	        }

	        return result;
	    }

	    // Helper function to print the result
	    public static void printArray(int[] arr) {
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
	        int k = 3;
	        
	        System.out.println("Original array: ");
	        printArray(nums);

	        int[] result = maxSlidingWindow(nums, k);
	        
	        System.out.println("Maximums of each sliding window of size " + k + ": ");
	        printArray(result);
	    }
	}


