import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Hristo on 29.07.2016 г..
 */
public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        while (!text.equals("END")){
            if (text.equals("ListAll"))
            {
                for (Map.Entry<String, String> pair : phoneBook.entrySet())
                {
                    System.out.println(pair.getKey() + " -> " + pair.getValue());
                }
            }
            else {
                String[] textArr = text.split(" ");

                switch (textArr[0]) {
                    case "A":
                        AddElement(phoneBook, textArr);
                        break;
                    default:
                        SearchElement(phoneBook, textArr);
                        break;
                }
            }
            text = scanner.nextLine();
        }
    }
    private static void AddElement(TreeMap<String, String> phoneBook, String[] textArr)
    {
        if (textArr.length == 2)
        {
            if (phoneBook.containsKey(textArr[1]))
            {
                phoneBook.put(textArr[1], textArr[2]);
            }
            else
            {
                phoneBook.put(textArr[1], "");
            }
        }
        else
        {
            if (phoneBook.containsKey(textArr[1]))
            {
                phoneBook.put(textArr[1], textArr[2]);
            }
            else
            {
                phoneBook.put(textArr[1], textArr[2]);
            }
        }
    }
    private static void SearchElement(TreeMap<String, String> phoneBook, String[] textArr)
    {
        boolean flag = false;
        for (Map.Entry<String, String> pair : phoneBook.entrySet())
        {
            if (textArr[1].equals(pair.getKey()))
            {
                System.out.println(pair.getKey() + " -> " + pair.getValue());
                flag = true;
            }
        }
        if (flag == false)
        {
            System.out.println("Contact " + textArr[1] + " does not exist.");
        }
    }
}
