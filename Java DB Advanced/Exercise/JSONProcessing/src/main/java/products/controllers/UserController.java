package products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import products.dto.bindings.UserImportDto;
import products.dto.views.UserNameSoldProductsViewDto;
import products.dto.views.SummaryUsersSoldProductsViewDto;
import products.serializers.JsonSerializer;
import products.services.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

@Controller
public class UserController {
    private static final String USERS_JASON_PATH = "/json/input/users.json";
    private static final String SOLD_PRODUCTS_JASON_OUTPUT_PATH = "src/main/resources/json/output/soldProducts.json";
    private static final String USERS_PRODUCTS_JASON_OUTPUT_PATH = "src/main/resources/json/output/users-and-products.json";

    private final UserService userService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public UserController(UserService userService, JsonSerializer jsonSerializer) {
        this.userService = userService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importUsers() throws IOException, InstantiationException, IllegalAccessException {
        UserImportDto[] userImportDtos = this.jsonSerializer.deserialize(UserImportDto[].class, USERS_JASON_PATH);
        this.userService.createMany(Arrays.asList(userImportDtos));
    }

    public void exportUsersWithSoldProducts() throws InstantiationException, IllegalAccessException, IOException {
        List<UserNameSoldProductsViewDto> users = this.userService.getUsersBySoldProducts();
        this.jsonSerializer.serialize(users, SOLD_PRODUCTS_JASON_OUTPUT_PATH);
    }

    public void exportUsersAndProducts() throws IOException, InstantiationException, IllegalAccessException {
        SummaryUsersSoldProductsViewDto summary = this.userService.findUsers();
        this.jsonSerializer.serialize(summary, USERS_PRODUCTS_JASON_OUTPUT_PATH);
    }
}