package gringotts.console;

import gringotts.entities.WizardDeposit;
import gringotts.services.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private WizardDepositService wizardDepositService;

    @Autowired
    public ConsoleRunner(WizardDepositService wizardDepositService) {
        this.wizardDepositService = wizardDepositService;
    }

    @Override
    public void run(String... strings) throws Exception {
        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Antoich Peverell");
        dumbledore.setMagicWandSize((short) 15);
        dumbledore.setDepositStartDate(LocalDateTime.of(2001, 10, 15, 8, 34, 48));
        dumbledore.setDepositExpirationDate(LocalDateTime.of(2020, 10, 15, 8, 34, 48));
        dumbledore.setDepositAmount(2000.24);
        dumbledore.setDepositCharge(0.2);
        dumbledore.setDepositExpired(false);

        this.wizardDepositService.create(dumbledore);
    }
}
