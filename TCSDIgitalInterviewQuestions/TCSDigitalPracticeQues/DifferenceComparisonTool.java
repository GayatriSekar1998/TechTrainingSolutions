public class DifferenceComparisonTool {

    public static void main(String[] args) {
        String X = "XMJYAUZ";
        String Y = "XMJAATZ";

        String difference = findDifference(X, Y);
        System.out.println("Difference: " + difference);
    }

    public static String findDifference(String X, String Y) {
        StringBuilder difference = new StringBuilder();

        int i = 0, j = 0;
        while (i < X.length() || j < Y.length()) {
            if (i < X.length() && j < Y.length() && X.charAt(i) == Y.charAt(j)) {
                i++;
                j++;
            } else {
                if (j < Y.length()) {
                    difference.append(" +" + Y.charAt(j));
                    j++;
                }
                if (i < X.length()) {
                    difference.append(" -" + X.charAt(i));
                    i++;
                }
            }
        }

        return difference.toString();
    }
}