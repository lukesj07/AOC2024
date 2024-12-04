package DayOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input");
        Scanner scanner = new Scanner(input);

        ArrayList<Integer> left = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split("\\s+");
            left.add(Integer.parseInt(split[0]));
            int rightNum = Integer.parseInt(split[1]);
            freqMap.put(rightNum, freqMap.getOrDefault(rightNum, 0) + 1);
        }
        
        int sum = 0;
        for (int num : left)
            sum += num * freqMap.getOrDefault(num, 0);

        System.out.println(sum);
        
        scanner.close();
    }
}
