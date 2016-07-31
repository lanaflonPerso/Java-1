import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class EqualSums {
    public static void main(String[] args) {

        int[] numbers = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean flag = true;

        for (int i = 0; i < numbers.length; i++)
        {
            int sumRight = 0;
            int sumLeft = 0;
            if (i == 0)
            {
                for (int j = 1; j < numbers.length; j++)
                {
                    sumRight += numbers[j];
                }
                if (sumLeft == sumRight)
                {
                    System.out.println(i);
                    flag = false;
                }
            }
            else
            {
                for (int k = i + 1; k < numbers.length; k++)
                {
                    sumRight += numbers[k];
                }
                for (int l = 0; l < i; l++)
                {
                    sumLeft += numbers[l];
                }
                if (sumLeft == sumRight)
                {
                    System.out.println(i);
                    flag = false;
                }
            }
        }
        if (flag == true)
        {
            System.out.println("no");
        }
    }
}
