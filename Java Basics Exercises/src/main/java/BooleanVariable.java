import java.util.Scanner;

/**
 * Created by Hristo on 28.07.2016 г..
 */
public class BooleanVariable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numHex = scan.next();

        boolean numInt = Boolean.parseBoolean(numHex);

        if(numInt){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
