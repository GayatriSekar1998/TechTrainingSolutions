import java.util.*;

public class DecodeWays {
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2];
        }
        
        backtrack(s, n, 0, new StringBuilder(), result, dp);
        return result;
    }

    private static void backtrack(String s, int n, int index, StringBuilder path, List<String> result, int[] dp) {
        if (index == n) {
            result.add(path.toString());
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (index + i <= n && dp[index + i] > 0) {
                String sub = s.substring(index, index + i);
                if ((i == 1 || (i == 2 && sub.charAt(0) != '0')) && Integer.parseInt(sub) <= 26) {
                    int length = path.length();
                    if (length != 0) path.append(' ');
                    path.append((char) ('A' + Integer.parseInt(sub) - 1));
                    backtrack(s, n, index + i, path, result, dp);
                    path.setLength(length);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> result1 = decode("226");
        System.out.println("Output1: " + result1);

        List<String> result2 = decode("271231");
        System.out.println("Output2: " + result2);
    }
}
