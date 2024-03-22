
public class OptimalTaskSelection {
    public static void main(String[] args) {
        String[] tasks = {"A", "B", "C"};
        int[] points = {1, 2, 3};
        int[] values = {1, 6, 10};
        int teamCapacity = 3;

        int maxTotalValue = findMaxTotalValue(tasks, points, values, teamCapacity);
        System.out.println("Maximum total value: " + maxTotalValue);
    }

    public static int findMaxTotalValue(String[] tasks, int[] points, int[] values, int teamCapacity) {
        int n = tasks.length;
        int[] dp = new int[teamCapacity + 1];

        for (int i = 0; i < n; i++) {
            for (int j = teamCapacity; j >= points[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - points[i]] + values[i]);
            }
        }

        return dp[teamCapacity];
    }
}
