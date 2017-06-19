
/******************************************************************************
 *  Compilation:  javac Parentheses.java
 *  Execution:    java Parentheses file.txt
 *  
 *  Reads in a text file and checks to see if the paretheses, curly
 *  braces, and square brackets are balanced.
 *
 *  % java  java Parentheses
 *  [()]{}{[()()]()}
 *  true
 *
 *  % java Parentheses
 *  [(])
 *  false
 *
 ******************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    public static boolean isBalanced(String s) {
    	// Put your solution here
    	// Hint: you might need to create a stack to keep characters
        //Stack<Character> stack = new Stack<Character>();
        
        return false;
    }


    public static void main(String[] args) throws FileNotFoundException {
       	Scanner fin = new Scanner(new FileReader("input.txt"));
        while (fin.hasNext()) {
            String str = fin.nextLine();
            System.out.println(str);
            System.out.println(isBalanced(str));
            System.out.println();
        }
    }

}