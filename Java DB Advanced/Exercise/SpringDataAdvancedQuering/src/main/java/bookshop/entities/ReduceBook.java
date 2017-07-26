package bookshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */

@Entity
@Table(name = "reduce_books")
public class ReduceBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(nullable = false)
    private int editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int ageRestriction;

    public ReduceBook() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionType() {
        return this.editionType;
    }

    public void setEditionType(int editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
