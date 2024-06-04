import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        str = scanner.next();
        if(isValidParentheses(str)){
            System.out.print("The given string is a valid Parentheses");
        } else {
            System.out.print("The given string is a not valid Parentheses");
        }

    }
    private static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<Character>();

        char[] ch = str.toCharArray();//(,)

        for(Character c : ch) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            else if(stack.isEmpty() || !comparePair(stack.pop(),c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean comparePair(Character pop, Character c) {
        if(pop == '(' && c == ')') {
            return true;
        }
        else if(pop == '{' && c == '}') {
            return true;
        }
        else if(pop == '[' && c == ']') {
            return true;
        }
        return false;
    }
}