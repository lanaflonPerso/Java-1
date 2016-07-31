import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 30.07.2016 г..
 */
public class MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        char letter1 = 'a';
        char letter2 = 'a';

        for (int row = 0; row < numbers[0]; row++)
        {
            letter2 = letter1;
            for (int col = 0; col < numbers[1]; col++)
            {
                System.out.print((char)letter1 + "" + (char)letter2 + "" + (char)letter1 + " ");
                letter2++;
            }
            System.out.println();
            letter1++;
        }
    }
}
