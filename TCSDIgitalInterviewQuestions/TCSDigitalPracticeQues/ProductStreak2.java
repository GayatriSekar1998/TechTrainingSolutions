import java.util.*;

public class ProductStreak2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] products = new int[num];
        for (int i = 0; i < num; i++) {
            products[i] = scanner.nextInt();
        }
        scanner.close();

        int maxLength = 0;
        int startIndex = -1;
        int endIndex = -1;
        Map<Integer, Integer> diffIndexMap = new HashMap<>();
        int diff = 0;

        // Initialize the map with diff = 0 at index -1
        diffIndexMap.put(0, -1);

        for (int i = 0; i < num; i++) {
            if (products[i] == 0)
                diff++;
            else
                diff--;

            if (diffIndexMap.containsKey(diff)) {
                int length = i - diffIndexMap.get(diff);
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = diffIndexMap.get(diff) + 1;
                    endIndex = i + 1;
                }
            } else {
                diffIndexMap.put(diff, i);
            }
        }

        if (startIndex == -1 && endIndex == -1) {
            System.out.println(-1);
        } else {
            System.out.println(startIndex + " " + endIndex);
        }
    }
}
