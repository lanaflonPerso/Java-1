import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class IndexofLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] ch = str.toCharArray();

        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 96; //for lower case
            if (temp <= 122 & temp >= 97)
                System.out.print(c);
                System.out.print(" -> ");
                System.out.println(temp - 96 - 1);
        }
    }
}
