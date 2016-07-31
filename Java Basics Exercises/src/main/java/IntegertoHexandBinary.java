import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class IntegertoHexandBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for (int i = 0; i < Hexadecimal(num).size(); i++) {
            System.out.print(Hexadecimal(num).get(i));
        }

        System.out.println();

        for (int i = 0; i < Binary(num).size(); i++) {
            System.out.print(Binary(num).get(i));
        }
    }
    private static ArrayList<String> Hexadecimal(int num)
    {
        int savenum = num;

        int counter = 0;

        while (num > 0)
        {
            num /= 16;
            counter++;
        }

        String[] remainderArray = new String[counter];

        int remainder = 0;
        for (int i = 0; i < counter; i++)
        {
            remainder = savenum % 16;

            switch (remainder)
            {
                case 10:
                    remainderArray[i] = "A";
                    break;
                case 11:
                    remainderArray[i] = "B";
                    break;
                case 12:
                    remainderArray[i] = "C";
                    break;
                case 13:
                    remainderArray[i] = "D";
                    break;
                case 14:
                    remainderArray[i] = "E";
                    break;
                case 15:
                    remainderArray[i] = "F";
                    break;

                default: remainderArray[i] = Integer.toString(remainder);
                    break;
            }
            savenum /= 16;
        }
        ArrayList<String> n = new ArrayList<>();
        for (int i = remainderArray.length - 1; i >= 0; i--)
        {
            n.add(remainderArray[i]);
        }
        return n;
    }

    private static ArrayList<Integer> Binary(int num)
    {
        int remainder;
        int newnum;
        int i = 0;
        ArrayList<Integer> n = new ArrayList<>();

        while (num != 0)
        {
            remainder = num % 2;
            newnum = num / 2;
            n.add(remainder);
            i++;
            num = newnum;
        }
        Collections.reverse(n);
        return n;
    }
}
