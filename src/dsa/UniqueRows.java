package dsa;


	import java.util.*;

	public class UniqueRows {

	    // Function to print all unique rows in a matrix
	    public static void printUniqueRows(int[][] matrix) {
	        // HashSet to store unique rows
	        Set<String> uniqueRows = new HashSet<>();
	        
	        // Iterate through each row
	        for (int[] row : matrix) {
	            // Convert row to a string to use it as a key in the set
	            String rowString = Arrays.toString(row);
	            
	            // If the row is not already in the set, add it
	            if (!uniqueRows.contains(rowString)) {
	                uniqueRows.add(rowString);
	                
	                // Print the unique row
	                System.out.println(Arrays.toString(row));
	            }
	        }
	    }

	    public static void main(String[] args) {
	        // Example matrix
	        int[][] matrix = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {1, 2, 3},  // Duplicate of the first row
	            {7, 8, 9},
	            {4, 5, 6},  // Duplicate of the second row
	            {10, 11, 12}
	        };

	        System.out.println("Unique rows in the matrix:");
	        printUniqueRows(matrix);
	    }
	}

	//Write  a function to print all unique rows of given matrix
