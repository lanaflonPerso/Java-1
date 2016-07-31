import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 30.07.2016 г..
 */
public class TwoxTwoquaresinMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {scanner.nextInt(), scanner.nextInt()};

        String[][] matrix = new String[numbers[0]][numbers[1]];

        for (int row = 0; row < numbers[0]; row++)
        {
            for (int col = 0; col < numbers[1]; col++)
            {
                matrix[row][col] = scanner.next();
            }
            System.out.println();
        }
        int count = 0;

        for (int row = 0; row < numbers[0] - 1; row++)
        {
            for (int col = 0; col < numbers[1] - 1; col++)
            {
                if (matrix[row][col].equals(matrix[row][col + 1]) &&
                matrix[row + 1][col + 1].equals(matrix[row][col + 1]) &&
                matrix[row + 1][col].equals(matrix[row + 1][col + 1]))
                {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
