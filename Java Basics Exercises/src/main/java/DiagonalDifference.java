import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 30.07.2016 г..
 */
public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int diagonalPrimary = 0;
        int diagonalSecond = 0;
        int diagonalPrimaryNextNumber = 0;
        int diagonalSecondNextNumber = n - 1;

        for (int i = 0; i < n; i++)
        {
            diagonalPrimary += matrix[i][diagonalPrimaryNextNumber];
            diagonalSecond += matrix[i][diagonalSecondNextNumber];
            diagonalPrimaryNextNumber++;
            diagonalSecondNextNumber--;
        }

        int difference = Math.abs(diagonalPrimary - diagonalSecond);

        System.out.println(difference);
    }
}
