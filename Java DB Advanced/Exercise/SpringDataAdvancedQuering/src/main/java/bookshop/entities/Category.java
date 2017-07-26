package bookshop.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Category() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}