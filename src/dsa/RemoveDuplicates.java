package dsa;


	public class RemoveDuplicates {
	    public static int removeDuplicates(int[] arr) {
	        if (arr.length == 0) {
	            return 0;
	        }
	        
	        int uniqueIndex = 1; // Pointer for the position of unique elements
	        
	        for (int i = 1; i < arr.length; i++) {
	            // If the current element is different from the previous one
	            if (arr[i] != arr[i - 1]) {
	                arr[uniqueIndex] = arr[i];
	                uniqueIndex++;
	            }
	        }
	        
	        return uniqueIndex; // Return the length of the unique elements
	    }

	    public static void main(String[] args) {
	        int[] sortedArray = {1, 1, 2, 3, 3, 4, 5, 5};
	        
	        int newLength = removeDuplicates(sortedArray);
	        
	        System.out.println("New length: " + newLength);
	        System.out.print("Modified array: ");
	        
	        for (int i = 0; i < newLength; i++) {
	            System.out.print(sortedArray[i] + " ");
	        }
	    }
	}

//sorted array
