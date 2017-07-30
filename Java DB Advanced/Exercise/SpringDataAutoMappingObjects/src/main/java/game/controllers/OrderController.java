package game.controllers;

import game.annotations.Command;
import game.dto.GameDto;
import game.dto.OrderDto;
import game.dto.UserGamesDto;
import game.entities.Game;
import game.entities.Order;
import game.entities.User;
import game.services.GameService;
import game.services.OrderService;
import game.services.UserService;
import game.utilities.FetchCommands;
import game.utilities.MapperConverter;
import game.utilities.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Controller
public class OrderController {

    private final GameService gameService;
    private final UserService userService;
    private final OrderService orderService;
    private final FetchCommands fetchCommands;
    private final Tokens tokens;
    private final MapperConverter mapperConverter;

    @Autowired
    public OrderController(GameService gameService, UserService userService, OrderService orderService, FetchCommands fetchCommands, Tokens tokens, MapperConverter mapperConverter) {
        this.gameService = gameService;
        this.userService = userService;
        this.orderService = orderService;
        this.fetchCommands = fetchCommands;
        this.tokens = tokens;
        this.mapperConverter = mapperConverter;
    }

    @Command(name = "AddToShoppingCart")
    public String addGameToShoppingCart() throws InstantiationException, IllegalAccessException {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length != 1) {
            return "Wrong number og arguments";
        }

        Game game = this.gameService.findGameByTitle(tokens[0]);
        if (game == null) {
            return String.format("%s not exist", tokens[0]);
        }

        User user = this.userService.findUserByLoggedInIsTrue();
        if (user == null) {
            return "Please logged in first";
        }

        Order order = this.orderService.findOrderByUser(user);

        if (order != null && order.getGames().stream().map(Game::getId).collect(Collectors.toList()).contains(game.getId())) {
            return "Cannot add this game, because you already has it";
        }

        Set<Game> games;
        if (order == null) {
            order = new Order();
            order.setUser(user);
            games = new HashSet<>();
        } else {
            games = order.getGames();
        }

        games.add(game);
        order.setGames(games);

        this.orderService.updateOne(order);

        return String.format("%s added to cart.", game.getTitle());
    }

    @Command(name = "RemoveFromShoppingCart")
    public String removeGameFromShoppingCart() {
        String[] tokens = this.tokens.getCommandTokens();
        if (tokens.length != 1) {
            return "Wrong number og arguments";
        }

        Game game = this.gameService.findGameByTitle(tokens[0]);
        if (game == null) {
            return String.format("%s not exist", tokens[0]);
        }

        User user = this.userService.findUserByLoggedInIsTrue();
        if (user == null) {
            return "Please logged in first";
        }

        Order order = this.orderService.findOrderByUser(user);

        if (order == null || !order.getGames().stream().map(Game::getId).collect(Collectors.toList()).contains(game.getId())) {
            return "Cannot remove this game, because you has not it";
        }

        this.orderService.removeGameFromOrderById(order.getId(), game.getId());

        return String.format("%s removed from cart.", game.getTitle());
    }

    @Command(name = "BuyGames")
    public String buyGames() {
        User user = this.userService.findUserByLoggedInIsTrueWithGames();
        if (user == null) {
            return "Please logged in first";
        }

        Order order = this.orderService.findOrderByUser(user);

        if (order == null || order.getGames().size() == 0) {
            return "You have not games to buy";
        }

        UserGamesDto userGamesDto = this.mapperConverter.convertOne(user, UserGamesDto.class);
        OrderDto orderDto = this.mapperConverter.convertOne(order, OrderDto.class);

        List<Long> userGameIds = userGamesDto.getGames().stream().map(GameDto::getId).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("Successfully bought games:");
        for (GameDto orderGame : orderDto.getGames()) {
            if (!userGameIds.contains(orderGame.getId())) {
                sb.append(System.lineSeparator()).append(String.format("\t-%s",orderGame.getTitle()));
                this.tokens.setCommandTokens(new String[]{orderGame.getTitle()});
                this.removeGameFromShoppingCart();
                userGamesDto.getGames().add(orderGame);
            }
        }

        this.mapperConverter.convertOne(userGamesDto, user);

        this.userService.updateOne(user);

        return sb.toString();
    }
}