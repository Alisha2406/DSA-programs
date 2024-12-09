package dsa;



	import java.util.*;

	class BinaryTree {
	    static class TreeNode {
	        int val;
	        TreeNode left, right;
	        TreeNode(int val) {
	            this.val = val;
	            left = right = null;
	        }
	    }

	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) return result;

	        // Two stacks to store nodes for each level
	        Stack<TreeNode> currentLevel = new Stack<>();
	        Stack<TreeNode> nextLevel = new Stack<>();
	        
	        // Start with the root node
	        currentLevel.push(root);
	        
	        // Boolean flag to switch between left-to-right and right-to-left
	        boolean leftToRight = true;

	        while (!currentLevel.isEmpty()) {
	            List<Integer> levelValues = new ArrayList<>();
	            
	            // Process nodes of the current level
	            while (!currentLevel.isEmpty()) {
	                TreeNode node = currentLevel.pop();
	                levelValues.add(node.val);

	                // Push children to the next level stack
	                if (node.left != null) nextLevel.push(node.left);
	                if (node.right != null) nextLevel.push(node.right);
	            }

	            // Add the current level's values to the result
	            result.add(levelValues);

	            // Switch the direction of traversal for the next level
	            leftToRight = !leftToRight;

	            // Swap the currentLevel and nextLevel stacks
	            currentLevel = nextLevel;
	            nextLevel = new Stack<>();
	        }

	        return result;
	    }

	    // Helper method to build a sample binary tree
	    public static TreeNode buildSampleTree() {
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(7);
	        return root;
	    }

	    public static void main(String[] args) {
	        BinaryTree tree = new BinaryTree();
	        TreeNode root = buildSampleTree();
	        List<List<Integer>> result = tree.zigzagLevelOrder(root);

	        // Print the result
	        for (List<Integer> level : result) {
	            System.out.println(level);
	        }
	    }
	}


