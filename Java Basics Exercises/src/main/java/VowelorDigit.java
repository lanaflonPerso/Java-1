import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class VowelorDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char letter= scan.next().charAt(0);

        if(isVowel(Character.toString(letter))){
            System.out.println("vowel");
        }
        else if(Character.isDigit(letter)){
            System.out.println("digit");
        }
        else{
            System.out.println("other");
        }
    }

    public static boolean isVowel(String letter) {

        return "AEIOUaeiou".indexOf(letter) != -1;
    }
}
