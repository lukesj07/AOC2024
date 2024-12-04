package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        int sum = 0;
        while (scanner.hasNextLine()) {
            int[] levels = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
            if (allowed(levels)) sum++;
        }

        System.out.println(sum);
        scanner.close();
    }

    public static boolean allowed(int[] levels) {
        int last = levels[0];
        boolean ascending = true, descending = true, gap = true;
        for (int i = 1; i < levels.length; i++) {
            int diff = Math.abs(levels[i] - last);
            if (diff < 1 || diff > 3) {
                gap = false;
                break;
            }
            if (ascending && levels[i] < last) ascending = false;
            if (descending && levels[i] > last) descending = false;
            last = levels[i];
        }
        return gap && (ascending || descending);
    }
}
