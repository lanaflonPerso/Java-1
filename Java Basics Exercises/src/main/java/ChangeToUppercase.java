import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;
import java.util.Scanner;

public class ChangeToUppercase {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");

        List<String> normalSizeWords = new ArrayList<>();
        List<String> upperSizeWords = new ArrayList<>();

        normalSizeWords = getTagValues(str); // Prints [apple, orange, pear]

        for (int i = 0; i < normalSizeWords.size(); i++) {
            upperSizeWords.add(normalSizeWords.get(i).toUpperCase());
        }

        for (int i = 0; i < upperSizeWords.size(); i++) {
            str = str.replaceAll("(?<=<upcase>).*?(?=</upcase>)", upperSizeWords.get(i));
        }

        String replacedStr = str.replace("<upcase>", "");
        System.out.println(replacedStr.replace("</upcase>", ""));
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
