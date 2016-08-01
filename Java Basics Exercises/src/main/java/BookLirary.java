import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Hristo on 31.07.2016 г..
 */
public class BookLirary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int num = scanner.nextInt();
        List<Book> library = new ArrayList<Book>();
        TreeMap<String, Double> totalPriceByAuthor = new TreeMap<>();

        for (int i = 0; i < num; i++)
        {
            String[] bookArr = scanner.next().split(" ");
            Book book = new Book();

                book.Title = bookArr[0];
                book.Author = bookArr[1];
                book.publisher = bookArr[2];
                book.ISBNnumber = Integer.parseInt(bookArr[4]);
                book.Price = Double.parseDouble(bookArr[5]);

            if (i == 0){
                totalPriceByAuthor.put(book.Author, book.Price);
            }
            else {
                if (totalPriceByAuthor.containsKey(bookArr[1])){
                    totalPriceByAuthor.put(book.Author, book.getPrice() + book.Price);
                }
                else {
                    totalPriceByAuthor.put(book.Author, book.Price);
                }
            }
        }

        System.out.println(totalPriceByAuthor);
        System.out.println(entriesSortedByValues(totalPriceByAuthor));
    }
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    static final Comparator<Book> SENIORITY_ORDER =
            new Comparator<Book>() {
                public int compare(Book e1, Book e2) {
                    if(e1.Price > e2.Price){
                        return -1;
                    }
                    return e1.Title.compareTo(e2.Title);
                }
            };

}
