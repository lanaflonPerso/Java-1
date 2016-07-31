/*
import java.util.Scanner;

class URLParser
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        String server = null;

        if (text.contains("://"))
        {
            System.out.println("[protocol] = " + text.substring(0, text.indexOf("://")));
            server = (text.substring(text.lastIndexOf("://")).remove(0, 3));

            if ((text.Substring(text.LastIndexOf("://")).Remove(0, 3)).Contains("/"))
            {
                Console.WriteLine("[server] = \"{0}\"", (text.Substring(text.LastIndexOf("://")).Remove(0, 3)).Substring(0, server.IndexOf("/")));
                Console.WriteLine("[resource] = \"{0}\"", (text.Substring(text.LastIndexOf("://")).Remove(0, 3)).Substring(server.IndexOf("/") + 1));
            }
            else
            {
                Console.WriteLine("[server] = \"{0}\"", text.Substring(text.LastIndexOf("://")).Remove(0, 3));
                Console.WriteLine("[resource] = \"{0}\"", "");
            }
        }
        else
        {
            if (text.Contains("/"))
            {
                Console.WriteLine("[protocol] = \"{0}\"", "");
                Console.WriteLine("[server] = \"{0}\"", server = text.Substring(0, text.IndexOf("/")));
                Console.WriteLine("[resource] = \"{0}\"", "");
            }
            else
            {
                Console.WriteLine("[protocol] = \"{0}\"", "");
                Console.WriteLine("[server] = \"{0}\"", text);
                Console.WriteLine("[resource] = \"{0}\"", "");
            }
        }
    }
}
}
*/
