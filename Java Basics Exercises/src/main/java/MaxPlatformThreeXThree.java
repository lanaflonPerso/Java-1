import java.util.Scanner;

/**
 * Created by Hristo on 30.07.2016 г..
 */
public class MaxPlatformThreeXThree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] n = {scanner.nextInt(), scanner.nextInt()};

        long[][] matrix = new long[n[0]][n[1]];

        for (int i = 0; i < n[0]; i++)
        {
            for (int j = 0; j < n[1]; j++)
            {
                matrix[i][j] = scanner.nextLong();
            }
        }

        int posRow = 0;
        int posCol = 0;
        long maxResult = Long.MIN_VALUE;
        int row = 0;

        for (int i = 0; i < n[0] - 2; i++)
        {
            int col = 0;
            for (int j = 0; j < n[1] - 2; j++)
            {
                long tempMaxResult = 0;
                tempMaxResult = tempResultMaxMethod(n, matrix, tempMaxResult, row, col);
                if (tempMaxResult > maxResult)
                {
                    posRow = i;
                    posCol = j;
                    maxResult = tempMaxResult;
                }
                col++;
            }
            row++;
        }

        System.out.println(maxResult);

        for (int i = posRow; i < posRow + 3; i++)
        {
            for (int j = posCol; j < posCol + 3; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static long tempResultMaxMethod(int[] n, long[][] matrix, long tempMaxResult, int row, int col)
    {
        long counterRow = 0;
        long counterCol = 0;
        for (int i = row; i < n[0]; i++)
        {
            if (counterRow == 3)
            {
                break;
            }
            for (int j = col; j < n[1]; j++)
            {
                if (counterCol == 3)
                {
                    break;
                }
                tempMaxResult += matrix[i][j];
                counterCol++;
            }
            counterRow++;
            counterCol = 0;
        }

        return tempMaxResult;
    }
}
