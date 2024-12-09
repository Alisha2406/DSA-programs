package dsa;


	import java.util.*;

	 public class InfixToPostfix {
	    
	    // Define operator precedence
	    private static int precedence(char operator) {
	        switch (operator) {
	            case '+':
	            case '-': return 1;
	            case '*':
	            case '/': return 2;
	            case '^': return 3;
	            default: return -1;
	        }
	    }

	    // Function to convert infix expression to postfix expression
	    public static String infixToPostfix(String infix) {
	        // Stack for operators
	        Stack<Character> stack = new Stack<>();
	        // StringBuilder to store the postfix expression
	        StringBuilder postfix = new StringBuilder();

	        // Traverse the given infix expression
	        for (int i = 0; i < infix.length(); i++) {
	            char ch = infix.charAt(i);

	            // If the current character is an operand, add it to the result
	            if (Character.isLetterOrDigit(ch)) {
	                postfix.append(ch);
	            }
	            // If the current character is '(', push it to the stack
	            else if (ch == '(') {
	                stack.push(ch);
	            }
	            // If the current character is ')', pop and append to result until '(' is encountered
	            else if (ch == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(') {
	                    postfix.append(stack.pop());
	                }
	                stack.pop(); // Pop '('
	            }
	            // If the current character is an operator
	            else {
	                // Pop operators from stack to result if they have higher or equal precedence
	                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
	                    postfix.append(stack.pop());
	                }
	                // Push the current operator onto the stack
	                stack.push(ch);
	            }
	        }

	        // Pop all the remaining operators from the stack
	        while (!stack.isEmpty()) {
	            postfix.append(stack.pop());
	        }

	        // Convert StringBuilder to String and return
	        return postfix.toString();
	    }

	    public static void main(String[] args) {
	        // Test the conversion of infix to postfix
	        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
	        String postfixExpression = infixToPostfix(infixExpression);
	        System.out.println("Infix Expression: " + infixExpression);
	        System.out.println("Postfix Expression: " + postfixExpression);
	    }
	}


