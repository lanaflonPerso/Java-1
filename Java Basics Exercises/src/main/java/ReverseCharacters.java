import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class ReverseCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> letters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String letter = scan.next();
            letters.add(letter);
        }

        Collections.reverse(letters);

        for (int i = 0; i < 3; i++) {
            System.out.print(letters.get(i));
        }
    }
}
