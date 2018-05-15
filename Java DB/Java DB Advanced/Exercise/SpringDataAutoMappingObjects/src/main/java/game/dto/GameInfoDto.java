package game.dto;

import java.math.BigDecimal;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

public class GameInfoDto {

    private String title;

    private BigDecimal price;

    public GameInfoDto() {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
