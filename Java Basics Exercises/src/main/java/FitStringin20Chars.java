import java.util.Scanner;

public class FitStringin20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] str = scanner.nextLine().toCharArray();

        if (str.length >= 20){
            for (int i = 0; i < 20; i++) {
                System.out.print(str[i]);
            }
        }
        else{
            int starsNumber = 20 - str.length;
            String stars = new String(new char[starsNumber]).replace("\0", "*");
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println(stars);
        }
    }
}
