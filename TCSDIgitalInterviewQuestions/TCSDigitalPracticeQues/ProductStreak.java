import java.util.Scanner;

public class ProductStreak {
    public static void main(String[] args) {
        int num;
        int[] products;
        try (Scanner scanner = new Scanner(System.in)) {
            num = scanner.nextInt();
            products = new int[num]; // {1, 0, 1, 1, 1, 0, 0, 1}
            for (int i = 0; i < num; i++) {
                products[i] = scanner.nextInt();
            }
        }

        int maxLength = 0;
        int startIndex = -1;
        int endIndex = -1;
        int count0 = 0;
        int count1 = 0;
        int[] counts = new int[2 * num + 1];

        for (int i = 0; i < num; i++) {
            if (products[i] == 0)
                count0++;
            else
                count1++;

            int diff = count0 - count1;
            if (diff == 0) {
                maxLength = i + 1;
                startIndex = 1;
                endIndex = i + 1;
            } else if (counts[diff + num] != 0) {
                int length = i - counts[diff + num] + 1;
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = counts[diff + num] + 1;
                    endIndex = i + 1;
                }
            } else {
                counts[diff + num] = i + 1;
            }
        }

        if (startIndex == -1 && endIndex == -1) {
            System.out.println(-1);
        } else {
            System.out.println(startIndex + " " + endIndex);
        }
    }
}
