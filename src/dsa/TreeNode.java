package dsa;


	import java.util.*;

	// TreeNode class for Binary Search Tree
 public	class TreeNode {
	    int val;
	    TreeNode left, right;
	    TreeNode(int x) { val = x; }
 

	public class MergeBST {

	    // Function to perform in-order traversal of a tree and store the result in a list
	    private static void inorderTraversal(TreeNode root, List<Integer> result) {
	        if (root == null) return;
	        inorderTraversal(root.left, result);
	        result.add(root.val);
	        inorderTraversal(root.right, result);
	    }

	    // Function to merge two sorted lists into one sorted list
	    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
	        List<Integer> mergedList = new ArrayList<>();
	        int i = 0, j = 0;
	        
	        // Merge the two lists
	        while (i < list1.size() && j < list2.size()) {
	            if (list1.get(i) < list2.get(j)) {
	                mergedList.add(list1.get(i));
	                i++;
	            } else {
	                mergedList.add(list2.get(j));
	                j++;
	            }
	        }
	        
	        // Add remaining elements from list1
	        while (i < list1.size()) {
	            mergedList.add(list1.get(i));
	            i++;
	        }

	        // Add remaining elements from list2
	        while (j < list2.size()) {
	            mergedList.add(list2.get(j));
	            j++;
	        }

	        return mergedList;
	    }

	    // Function to convert a sorted list to a balanced BST
	    private static TreeNode sortedListToBST(List<Integer> sortedList, int start, int end) {
	        if (start > end) {
	            return null;
	        }
	        
	        int mid = (start + end) / 2;
	        TreeNode node = new TreeNode(sortedList.get(mid));
	        
	        node.left = sortedListToBST(sortedList, start, mid - 1);
	        node.right = sortedListToBST(sortedList, mid + 1, end);
	        
	        return node;
	    }

	    // Function to merge two BSTs
	    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
	        // Step 1: Perform in-order traversal of both trees to get two sorted lists
	        List<Integer> list1 = new ArrayList<>();
	        List<Integer> list2 = new ArrayList<>();
	        
	        inorderTraversal(root1, list1);
	        inorderTraversal(root2, list2);
	        
	        // Step 2: Merge the two sorted lists
	        List<Integer> mergedList = mergeSortedLists(list1, list2);
	        
	        // Step 3: Convert the merged sorted list into a balanced BST
	        return sortedListToBST(mergedList, 0, mergedList.size() - 1);
	    }

	    // Helper function to print the tree (in-order traversal)
	    private static void inorderPrint(TreeNode root) {
	        if (root != null) {
	            inorderPrint(root.left);
	            System.out.print(root.val + " ");
	            inorderPrint(root.right);
	        }
	    }

	    public static void main(String[] args) {
	        // Create two BSTs for testing
	        TreeNode root1 = new TreeNode(3);
	        root1.left = new TreeNode(1);
	        root1.right = new TreeNode(5);
	        root1.left.left = new TreeNode(0);
	        root1.left.right = new TreeNode(2);
	        root1.right.left = new TreeNode(4);
	        root1.right.right = new TreeNode(6);

	        TreeNode root2 = new TreeNode(8);
	        root2.left = new TreeNode(7);
	        root2.right = new TreeNode(9);

	        // Merge the two BSTs
	        TreeNode mergedRoot = mergeBSTs(root1, root2);

	        // Print the in-order traversal of the merged BST (should be sorted)
	        System.out.println("Merged BST (in-order traversal):");
	        inorderPrint(mergedRoot);  // Expected output: 0 1 2 3 4 5 6 7 8 9
	    }
	}

 }
