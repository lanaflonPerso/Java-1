import java.util.*;

/**
Dobavka
 * Created by Hristo on 30.07.2016 г..
 */
public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events =  {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();
        int phraseIndex = 0;
        int eventIndex = 0;
        int authorIndex = 0;
        int cityIndex = 0;
        for (int i = 0; i < 3; i++)
        {
            System.out.println(phrases[phraseIndex = rnd.nextInt(phrases.length)] +  events[eventIndex = rnd.nextInt(events.length)] + authors[authorIndex = rnd.nextInt(authors.length)] + " - " + cities[cityIndex = rnd.nextInt(cities.length)]);
        }
    }
}
