package postfixconverter;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixConverter {
	// array that store all possible variables
	private static char[] lowerCaseChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	// helper method to check if the char is a variable
	private static boolean checkIfAVariable(char c) {
		for (char variable: lowerCaseChars) {
			if (variable == c) return true;
		}
		return false;
	}
	
	// return precedence of operator, 3 for ^, 2 for * and /, 1 for + and -
	private static int checkPrecedence(char c) {
		if (c == '^') return 3;
		if (c == '*' || c == '/') return 2;
		if (c == '+' || c == '-') return 1;
		return -1;
	}
	
	public static String convertToPostfix(String infix) {
		// stack to store operators 
		Deque<String> operatorStack = new ArrayDeque<String>();
		
		// string to store postfix expression
		String postfix = "";
		
		// loop to iterate through infix String
		for (char c: infix.toCharArray()) {
			// if - else statement to check each case
			//if c is a variable, append to postfix string
			if (checkIfAVariable(c)) {
				postfix += c;
			} 
			// if c is a power operator, append to operator stack
			else if (c == '^') {
				operatorStack.addFirst(String.valueOf(c));
			}
			// if c is +, -, *, /, then do the following
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				// if c has a lower precedence than the operator on top of the stack
				// we will add to the postfix string now, else push to operator stack
				int precedenceOfC = checkPrecedence(c);
				while (!operatorStack.isEmpty() && precedenceOfC <= checkPrecedence(operatorStack.getFirst().charAt(0))) {
					postfix += operatorStack.getFirst();
					operatorStack.removeFirst();
				}
				operatorStack.addFirst(String.valueOf(c));
				
			}
			// if c is an open parenthesis, push to operator stack
			else if (c == '(') {
				operatorStack.addFirst(String.valueOf(c));
			}
			// if c is a close parenthesis, do the following
			else if (c == ')') {
				String topOperator = operatorStack.removeFirst();
				while (!topOperator.equals("(")) {
					// add operator to postfix
					postfix += topOperator;
					topOperator = operatorStack.removeFirst();
				}
			}
			// ignore unexpected char
			else {
				continue;
			}
		}
		// remaining operator to postfix if stack not empty
		
		while (!operatorStack.isEmpty()) {
			postfix += operatorStack.removeFirst();
		}
		return postfix;
	}

	public static void main(String[] args) {
	}

}
