package game.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 28/07/2017.
 */

@Entity
@Table(name = "games")
public class Game {
    private static final int TRAILER_LENGTH = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private long id;

    @Basic
    private String title;

    @Basic
    private String trailer;

    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    @Basic
    private double size;

    @Basic
    private BigDecimal price;

    @Basic
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "games", cascade = CascadeType.ALL)
    private Set<User> users;

    @ManyToMany(mappedBy = "games", cascade = CascadeType.ALL, fetch = FetchType.EAGER)    private Set<Order> orders;

    public Game() {
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public String getImageThumbnail() {
        return this.imageThumbnail;
    }

    public double getSize() {
        return this.size;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if (!Character.isUpperCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) {
            throw new IllegalArgumentException("Incorrect title of game");
        }
        this.title = title;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer.substring(trailer.length() - TRAILER_LENGTH);
    }

    public void setImageThumbnail(String imageThumbnail) {
        if (!imageThumbnail.startsWith("http://") && !imageThumbnail.startsWith("https://") && !imageThumbnail.startsWith("null")) {
            throw new IllegalArgumentException("Incorrect imageThumbnail");
        }
        this.imageThumbnail = imageThumbnail;
    }

    public void setSize(double size) {
        if (size < 0 || String.valueOf(size).split("\\.")[1].length() > 1) {
            throw new IllegalArgumentException("Incorrect size of game");
        }
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0 || String.valueOf(price).split("\\.")[1].length() > 2) {
            throw new IllegalArgumentException("Incorrect price of game");
        }
        this.price = price;
    }

    public void setDescription(String description) {
        if (description.length() < 20) {
            throw new IllegalArgumentException("Incorrect length of description, please insert minimum 20 symbols");
        }
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String toString() {
        return "game.entities.Game(id=" + this.getId() + ", title=" + this.getTitle() + ", trailer=" + this.getTrailer() + ", imageThumbnail=" + this.getImageThumbnail() + ", size=" + this.getSize() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", releaseDate=" + this.getReleaseDate() + ")";
    }
}
