import java.util.Stack;

public class EvaluateRPN {
    public static int evalRPN(String[] tokens) {// "3" "4" "+"
        Stack<Integer> stack = new Stack<>();  // stack is filled with zeros
//  3 4 +
        for (String token : tokens) {
            switch (token) { // token = "+"
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};// (2+1)*3 => 2 1 + * 3 ==> 2 1 + 3 *
//        String[] tokens2 = {"4", "13", "5", "/", "+"};
//        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(tokens1)); // 9
//        System.out.println(evalRPN(tokens2)); // 6
//        System.out.println(evalRPN(tokens3)); // 22
    }
}