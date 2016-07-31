import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;
import java.util.Scanner;

public class ChangeToUppercase {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            final String str = scanner.nextLine();
            System.out.println(Arrays.toString(getTagValues(str).toArray())); // Prints [apple, orange, pear]

        str.replace("<upcase>(.+?)</upcase>", "");

        System.out.println(str);
        }

        private static final Pattern TAG_REGEX = Pattern.compile("<upcase>(.+?)</upcase>");

        private static List<String> getTagValues(final String str) {
            final List<String> tagValues = new ArrayList<String>();
            final Matcher matcher = TAG_REGEX.matcher(str);
            while (matcher.find()) {
                tagValues.add(matcher.group(1));
            }
            return tagValues;
        }

    }
