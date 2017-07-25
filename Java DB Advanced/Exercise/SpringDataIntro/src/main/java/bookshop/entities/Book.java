package bookshop.entities;

import bookshop.enums.AgeRestriction;
import bookshop.enums.EditionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private int editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int copies;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int ageRestriction;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "fk_books_authors"))
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"),
            foreignKey = @ForeignKey(name = "fk_books_categories_books"),
            inverseForeignKey = @ForeignKey(name = "fk_books_categories_categories"))
    private Set<Category> categories;


    @ManyToMany(mappedBy = "relatedBooks", cascade = CascadeType.ALL)
    private Set<Book> books;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="related_books",
            joinColumns={@JoinColumn(name="related_id")},
            inverseJoinColumns={@JoinColumn(name="book_id")})
    private Set<Book> relatedBooks;

    public Book() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEditionType() {
        return this.editionType;
    }

    public void setEditionType(int editionType) {
        if (Arrays.stream(EditionType.values()).filter(x -> x.getValue() == editionType).count() == 0) {
            throw new IllegalArgumentException("Wrong edition type!");
        }
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return this.copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        if (Arrays.stream(AgeRestriction.values()).filter(x -> x.getValue() == ageRestriction).count() == 0) {
            throw new IllegalArgumentException("Wrong age restriction type!");
        }
        this.ageRestriction = ageRestriction;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Book> getRelatedBooks() {
        return this.relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", editionType=" + editionType +
                ", price=" + price +
                ", copies=" + copies +
                ", releaseDate=" + releaseDate +
                ", ageRestriction=" + ageRestriction +
                ", author=" + author +
                ", categories=" + categories +
                '}';
    }
}
