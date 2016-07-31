import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;

/**
 * Created by Hristo on 31.07.2016 г..
 */
public class BookLibraryModification {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int num = scanner.nextInt();
        List<Book> library = new ArrayList<Book>();
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd.M.yyyy");

        for (int i = 0; i < num; i++)
        {
            String[] bookArr = scanner.next().split(" ");
            Book book = new Book();
            try{
                book.Title = bookArr[0];
                book.Author = bookArr[1];
                book.publisher = bookArr[2];
                book.ReleaseDate = sdfmt.parse(bookArr[3]);
                book.ISBNnumber = Integer.parseInt(bookArr[4]);
                book.Price = Double.parseDouble(bookArr[5]);
            }
            catch (ParseException e){
                e.printStackTrace();
            }

            library.add(book);
        }
        String dateString = scanner.next();
        try {
            Date date = sdfmt.parse(dateString);
            Collections.sort(library, SENIORITY_ORDER);
            for (Book book : library)
            {
                if(book.ReleaseDate.compareTo(date)>0) {
                    System.out.print(book.Title);
                    System.out.printf("%s %te.%<tm.%<tY",
                            " -> ", book.ReleaseDate);
                    System.out.println();
                }
            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }
    static final Comparator<Book> SENIORITY_ORDER =
            new Comparator<Book>() {
                public int compare(Book e1, Book e2) {
                    if(e1.Title.equals(e2.Title)){
                        return -1;
                    }
                    return e1.ReleaseDate.compareTo(e2.ReleaseDate);
                }
            };

}
class Library
{
    public String NameOfBook;
    public List<Book> Books;

    public String getNameOfBook() {
        return NameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        NameOfBook = nameOfBook;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "NameOfBook='" + NameOfBook + '\'' +
                ", Books=" + Books +
                '}';
    }
}
class Book
{
    public String Title;
    public String Author;
    public String publisher;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    public int getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(int ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Date ReleaseDate;
    public int ISBNnumber;
    public double Price;

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ReleaseDate=" + ReleaseDate +
                ", ISBNnumber=" + ISBNnumber +
                ", Price=" + Price +
                '}';
    }
}
