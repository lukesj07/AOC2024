import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        ArrayList<char[]> grid = new ArrayList<>();
        while (scanner.hasNextLine()) grid.add(scanner.nextLine().toCharArray());
        System.out.println(findPattern(grid));
        scanner.close();
    }

    public static int findPattern(ArrayList<char[]> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length;
        int count = 0;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid.get(i)[j] == 'A') count += patterns(grid, i, j);
            }
        }

        return count;
    }

    public static int patterns(ArrayList<char[]> grid, int row, int col) {
        int patternCount = 0;
        if (grid.get(row - 1)[col - 1] == 'M' && grid.get(row + 1)[col + 1] == 'S' &&
            grid.get(row - 1)[col + 1] == 'S' && grid.get(row + 1)[col - 1] == 'M') {
            patternCount++;
        }
        if (grid.get(row - 1)[col - 1] == 'S' && grid.get(row + 1)[col + 1] == 'M' &&
            grid.get(row - 1)[col + 1] == 'M' && grid.get(row + 1)[col - 1] == 'S') {
            patternCount++;
        }
        if (grid.get(row + 1)[col - 1] == 'M' && grid.get(row - 1)[col + 1] == 'S' &&
            grid.get(row - 1)[col - 1] == 'S' && grid.get(row + 1)[col + 1] == 'M') {
            patternCount++;
        }
        if (grid.get(row + 1)[col - 1] == 'S' && grid.get(row - 1)[col + 1] == 'M' &&
            grid.get(row - 1)[col - 1] == 'M' && grid.get(row + 1)[col + 1] == 'S') {
            patternCount++;
        }
        return patternCount;
    }
}
