import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class VariableinHexFormat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numHex = scan.next();

        int numInt = Integer.parseInt(numHex, 16);

        System.out.println(numInt);
    }
}
