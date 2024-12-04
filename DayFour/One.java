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

        ArrayList<String> lines = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        scanner.close();
        System.out.println(searchPatterns(lines));
    }

    public static int searchPatterns(ArrayList<String> lines) {
        int count = 0;
        int rows = lines.size();
        int cols = lines.get(0).length();

        for (String line : lines) count += xmasCount(line);

        for (int col = 0; col < cols; col++) {
            StringBuilder vertLine = new StringBuilder();
            for (String horLine : lines) vertLine.append(horLine.charAt(col));
            count += xmasCount(vertLine.toString());
        }

        for (int start = 0; start < rows+cols-1; start++) {
            StringBuilder diag = new StringBuilder();
            for (int row = 0; row < rows; row ++) {
                int col = start - row;
                if (col >= 0 && col < cols) diag.append(lines.get(row).charAt(col));
            }
            count += xmasCount(diag.toString());
        }

        for (int start = 0; start < rows+cols-1; start++) {
            StringBuilder diag = new StringBuilder();
            for (int row = 0; row < rows; row ++) {
                int col = start + row - cols + 1;
                if (col >= 0 && col < cols) diag.append(lines.get(row).charAt(col));
            }
            count += xmasCount(diag.toString());
        }
        return count;
    }

    public static int xmasCount(String str) {
        Pattern pattern = Pattern.compile("(?=(XMAS|SAMX))");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
