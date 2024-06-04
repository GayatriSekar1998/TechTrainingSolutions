import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String encoded1 = "3[a]2[bc]";
        String encoded2 = "3[a2[c]]";
        String encoded3 = "2[abc]3[cd]ef";

        System.out.println(decodeString(encoded1)); // Output: "aaabcbc"
        System.out.println(decodeString(encoded2)); // Output: "accaccacc"
        System.out.println(decodeString(encoded3)); // Output: "abcabccdcdcdef"
    }
}