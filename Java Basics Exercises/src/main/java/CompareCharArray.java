import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class CompareCharArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] line1 = scan.nextLine().toCharArray();
        char[] line2 = scan.nextLine().toCharArray();
        int counter = 0;

        if (line1.length < line2.length)
        {
            for (int i = 0; i < line1.length; i++)
            {
                if (line1[i] > line2[i])
                {
                    System.out.println(String.valueOf(line2).replace(" ", ""));
                    System.out.println(String.valueOf(line1).replace(" ", ""));
                    break;
                }
                else if (line1[i] < line2[i])
                {
                    System.out.println(String.valueOf(line1).replace(" ", ""));
                    System.out.println(String.valueOf(line2).replace(" ", ""));
                    break;
                }
                else if (line1[i] == line2[i])
                {
                    counter++;
                    continue;
                }
            }
            if (counter == line1.length)
            {
                System.out.println(String.valueOf(line1).replace(" ", ""));
                System.out.println(String.valueOf(line2).replace(" ", ""));
            }
        }
        else
        {
            for (int i = 0; i < line2.length; i++)
            {
                if (line1[i] > line2[i])
                {
                    System.out.println(String.valueOf(line2).replace(" ", ""));
                    System.out.println(String.valueOf(line1).replace(" ", ""));
                    break;
                }
                else if (line1[i] < line2[i])
                {
                    System.out.println(String.valueOf(line1).replace(" ", ""));
                    System.out.println(String.valueOf(line2).replace(" ", ""));
                    break;
                }
                else if (line1[i] == line2[i])
                {
                    counter++;
                    continue;
                }
            }
            if (counter == line2.length)
            {
                System.out.println(String.valueOf(line2).replace(" ", ""));
                System.out.println(String.valueOf(line1).replace(" ", ""));
            }
        }
    }
}
