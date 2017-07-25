package sales.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sales.entities.Customer;
import sales.entities.Product;
import sales.entities.Sale;
import sales.entities.StoreLocation;
import sales.services.SaleService;

import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private SaleService saleService;

    @Autowired
    public ConsoleRunner(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public void run(String... strings) throws Exception {
        Product product = new Product("Iphone 5s", 1, 450);
        Customer customer = new Customer("Vasko", "vasko@abv.bg", "978541220587");
        StoreLocation storeLocation = new StoreLocation("Sofia");
        Sale sale = new Sale("FirstSale", product, customer, storeLocation, LocalDate.now());

        this.saleService.create(sale);
    }
}
