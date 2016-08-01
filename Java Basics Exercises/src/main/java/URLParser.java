import java.util.Scanner;

public class URLParser
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        String server = null;

        if (text.contains("://"))
        {
            System.out.println("[protocol] = " + "\"" + text.substring(0, text.indexOf("://")) + "\"");
            server = (text.substring(text.lastIndexOf("://")).replace("://", ""));

            if ((text.substring(text.lastIndexOf("://")).replace("://", "")).contains("/"))
            {
                System.out.println("[server] = " + "\"" + (text.substring(text.lastIndexOf("://")).replace("://", "")).substring(0, server.indexOf("/")) + "\"");
                System.out.println("[resource] = " + "\"" + (text.substring(text.lastIndexOf("://")).replace("://", "")).substring(server.indexOf("/") + 1) + "\"");
            }
            else
            {
                System.out.println("[server] = " + "\"" + text.substring(text.lastIndexOf("://")).replace("://", "") + "\"");
                System.out.println("[resource] = " + "\"" + "" + "\"");
            }
        }
        else
        {
            if (text.contains("/"))
            {
                System.out.println("[protocol] = " + "\"" + "" + "\"");
                System.out.println("[server] = " + "\"" + text.substring(0, text.indexOf("/")) + "\"");
                System.out.println("[resource] = " + "\"" + "" + "\"");
            }
            else
            {
                System.out.println("[protocol] = " + "\"" + "" + "\"");
                System.out.println("[server] = " + "\"" + text + "\"");
                System.out.println("[resource] = " + "\"" + "" + "\"");
            }
        }
    }
}
