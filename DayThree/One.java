import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        Pattern pattern = Pattern.compile("\\bmul\\((\\d+),(\\d+)\\)|\\b(do|don't)\\(\\)");
        int sum = 0; 
        boolean doMul = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null && matcher.group(2) != null) {
                    if (doMul) {
                        int arg1 = Integer.parseInt(matcher.group(1));
                        int arg2 = Integer.parseInt(matcher.group(2));
                        sum += arg1 * arg2;
                    }
                } else if ("do".equals(matcher.group(3))) {
                    doMul = true;
                } else if ("don't".equals(matcher.group(3))) {
                    doMul = false;
                }
            }
        }
        System.out.println(sum);
        scanner.close();
    }
}