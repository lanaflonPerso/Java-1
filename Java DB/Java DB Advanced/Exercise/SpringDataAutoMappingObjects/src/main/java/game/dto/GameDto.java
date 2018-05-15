package game.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

public class GameDto {

    private Long id;

    private String title;

    private BigDecimal price;

    private double size;

    private String trailer;

    private String imageThumbnail;

    private String description;

    private LocalDate releaseDate;

    public GameDto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = Double.parseDouble(size);
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return this.imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.releaseDate = LocalDate.parse(releaseDate, dtf);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nPrice: %.2f\nSize: %.2f\nTrailer: %s\nThumbnail URL: %s\nDescription: %s\nRelease date: %s", this.title, this.price, this.size, this.trailer, this.imageThumbnail, this.description, this.releaseDate);
    }
}