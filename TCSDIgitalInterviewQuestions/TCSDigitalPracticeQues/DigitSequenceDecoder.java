import java.util.ArrayList;
import java.util.List;

public class DigitSequenceDecoder {

    public static List<String> decode(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        if (digit == '0') {
            return; // Invalid, as '0' cannot represent any letter
        }

        // Decode single digit
        char singleChar = (char) (digit - '1' + 'A');
        current.append(singleChar);
        backtrack(digits, index + 1, current, result);
        current.deleteCharAt(current.length() - 1);

        // Decode two digits if possible
        if (index < digits.length() - 1) {
            int twoDigits = Integer.parseInt(digits.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                char twoChar = (char) (twoDigits - 1 + 'A');
                current.append(twoChar);
                backtrack(digits, index + 2, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "22";
        // String s2 = "271231";

        System.out.println("Output1 for " + s1 + ": " + decode(s1));
        // System.out.println("Output2 for " + s2 + ": " + decode(s2));
    }
}
