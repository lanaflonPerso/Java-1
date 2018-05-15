package game.controllers;

import game.annotations.Command;
import game.dto.GameDto;
import game.dto.GameInfoDto;
import game.dto.UserGamesDto;
import game.entities.Game;
import game.entities.User;
import game.services.GameService;
import game.services.UserService;
import game.utilities.FetchCommands;
import game.utilities.MapperConverter;
import game.utilities.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 29/07/2017.
 */

@Controller
public class GameController {

    private final GameService gameService;
    private final UserService userService;
    private final FetchCommands fetchCommands;
    private final Tokens tokens;
    private final MapperConverter mapperConverter;

    @Autowired
    public GameController(GameService gameService, UserService userService, FetchCommands fetchCommands, Tokens tokens, MapperConverter mapperConverter) {
        this.gameService = gameService;
        this.userService = userService;
        this.fetchCommands = fetchCommands;
        this.tokens = tokens;
        this.mapperConverter = mapperConverter;
    }

    @Command(name = "AddGame")
    public String addGame() {
        User user = this.userService.getUserIfLoggedInAndAdmin();
        if (user == null) {
            return "Access denied";
        }

        String[] tokens = this.tokens.getCommandTokens();

        if (tokens.length != 7) {
            return "Wrong number of parameters";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String title = tokens[0];
        BigDecimal price = new BigDecimal(tokens[1]);
        double size = Double.parseDouble(tokens[2]);
        String trailer = tokens[3];
        String thumbnailURL = tokens[4];
        String description = tokens[5];
        LocalDate localDate = LocalDate.parse(tokens[6], dtf);

        GameDto gameDto = new GameDto();
        gameDto.setTitle(title);
        gameDto.setPrice(price);
        gameDto.setSize(size);
        gameDto.setTrailer(trailer);
        gameDto.setImageThumbnail(thumbnailURL);
        gameDto.setDescription(description);
        gameDto.setReleaseDate(localDate);

        Game game;
        try {
            game = this.mapperConverter.convertOne(gameDto, Game.class);

            this.gameService.createOne(game);
        } catch (Exception e) {
            return e.getMessage();
        }

        return String.format("Added %s", game.getTitle());
    }

    @Command(name = "EditGame")
    public String editGame() throws IllegalAccessException, InvocationTargetException {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length < 2) {
            return "Wrong number of parameters";
        }

        User user = this.userService.getUserIfLoggedInAndAdmin();
        if (user == null) {
            return "Access denied";
        }

        Game game = gameService.findById(Long.parseLong(tokens[0]));

        if (game == null) {
            return "There is no game with such id";
        }

        GameDto gameDto = this.mapperConverter.convertOne(game, GameDto.class);

        for (String fieldValue : Arrays.stream(tokens).skip(1).toArray(String[]::new)) {
            String[] fieldValueTokens = fieldValue.split("=");
            Method method = Arrays.stream(gameDto.getClass()
                    .getDeclaredMethods())
                    .filter(m -> m.getName().contains("set")
                            && m.getName().contains(String.valueOf(fieldValueTokens[0].charAt(0)).toUpperCase() + fieldValueTokens[0].substring(1))
                            && m.getParameterTypes()[0].getSimpleName().equals("String"))
                    .findFirst()
                    .orElse(null);
            method.setAccessible(true);
            method.invoke(gameDto, fieldValueTokens[1]);
        }

        this.mapperConverter.convertOne(gameDto, game);
        this.gameService.updateOne(game);
        return String.format("Edited %s", game.getTitle());
    }

    @Command(name = "DeleteGame")
    public String deleteGame() {
        User user = this.userService.getUserIfLoggedInAndAdmin();
        if (user == null) {
            return "Access denied";
        }

        long id = Long.parseLong(this.tokens.getCommandTokens()[0]);

        Game game = this.gameService.findById(id);

        if (game == null) {
            return "There is no game with such id";
        }

        this.gameService.deleteById(id);

        return String.format("Deleted %s", game.getTitle());
    }

    @Command(name = "AllGames")
    public String printAllGames() throws InstantiationException, IllegalAccessException {

        List<Game> allGames = this.gameService.findAll();
        Set<Game> allGamesSet = new HashSet<>(allGames);

        Set<GameInfoDto> gameInfoDtos = this.mapperConverter.convertList(allGamesSet, GameInfoDto.class);

        return String.format("%s", gameInfoDtos.size() == 0 ? "No games" : gameInfoDtos.stream().map(g -> String.format("%s %.2f", g.getTitle(), g.getPrice())).collect(Collectors.joining(System.lineSeparator())));
    }

    @Command(name = "GameDetails")
    public String printGameDetails() {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length != 1) {
            return "Wrong number of parameters";
        }
        Game game = this.gameService.findGameByTitle(tokens[0]);
        if (game == null) {
            return String.format("%s not exist", tokens[0]);
        }

        GameDto gameDto = this.mapperConverter.convertOne(game, GameDto.class);

        return gameDto.toString();
    }

    @Command(name = "OwnedGames")
    public String printOwnedGames() throws InstantiationException, IllegalAccessException {
        User user = this.userService.findUserByLoggedInIsTrueWithGames();
        if (user == null) {
            return "You are not logged in";
        }

        UserGamesDto userGamesDto = this.mapperConverter.convertOne(user, UserGamesDto.class);

        Set<GameDto> gameDtos = userGamesDto.getGames();
        Set<GameDto> gameDtosSet = new HashSet<>(gameDtos);

        Set<Game> games = this.mapperConverter.convertList(gameDtosSet, Game.class);

        return String.format("%s", games.stream().map(Game::getTitle).collect(Collectors.joining(System.lineSeparator())));
    }
}
