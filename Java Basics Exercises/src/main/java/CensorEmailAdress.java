import java.util.Scanner;

public class CensorEmailAdress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String text = scan.nextLine();
        String[] mail = email.split("@");

        String str = new String(new char[mail[0].length()]).replace("\0", "*");

        String hideUser = str + "@" + mail[1];

        String rezult = text.replace(email, hideUser);

        System.out.println(rezult);
    }
}
