import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        int sum = 0;
        ArrayList<String> lines = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
            sum += xmasCount(line);
        }

        
        scanner.close();
        System.out.println(sum);
        
    }

    public static int xmasCount(String str) {
        Pattern pattern = Pattern.compile("XMAS|SAMX");
        Matcher matcher = pattern.matcher(str);
        int count = 0;

        while (matcher.find()) count++;

        return count;
    }
}