package game.utilities;

import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

@Component
public class Tokens {

    private String[] commandTokens;

    public Tokens() {
    }

    public String[] getCommandTokens() {
        return this.commandTokens;
    }

    public void setCommandTokens(String[] commandTokens) {
        this.commandTokens = commandTokens;
    }
}
