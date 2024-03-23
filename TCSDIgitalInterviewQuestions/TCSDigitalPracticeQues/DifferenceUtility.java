public class DifferenceUtility {

    public static void findDifference(String X, String Y) {
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        while (i < X.length() || j < Y.length()) {
            if (i < X.length() && j < Y.length() && X.charAt(i) == Y.charAt(j)) {
                result.append(X.charAt(i));
                i++;
                j++;
            } else {
                if (j < Y.length() && (i == X.length() || X.charAt(i) != Y.charAt(j))) {
                    result.append("+" + Y.charAt(j));
                    j++;
                }
                if (i < X.length() && (j == Y.length() || X.charAt(i) != Y.charAt(j))) {
                    result.append("-" + X.charAt(i));
                    i++;
                }
            }
        }

        System.out.println("Output: " + result.toString());
    }

    public static void main(String[] args) {
        String X = "XMJYAUZ";
        String Y = "XMJAATZ";
        findDifference(X, Y);
    }
}
