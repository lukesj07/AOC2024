package DayOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input");
        Scanner scanner = new Scanner(input);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split("\\s+");
            left.add(Integer.parseInt(split[0]));
            right.add(Integer.parseInt(split[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }
        System.out.println(sum);
        scanner.close();
    }
}