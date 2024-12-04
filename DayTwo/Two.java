import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        int sum = 0;
        while (scanner.hasNextLine()) {
            int[] levels = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
            if (allowed(levels) || canBeAllowed(levels)) sum++;
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

    public static boolean canBeAllowed(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            int[] modifiedLevels = new int[levels.length - 1];
            for (int j = 0, k = 0; j < levels.length; j++) {
                if (j != i) {
                    modifiedLevels[k++] = levels[j];
                }
            }
            if (allowed(modifiedLevels)) {
                return true;
            }
        }
        return false;
    }
}
