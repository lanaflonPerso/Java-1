import java.util.Scanner;

/**
 * Created by Hristo on 29.07.2016 г..
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] letters = scanner.nextLine().toCharArray();

        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i]);
        }


    }
}
