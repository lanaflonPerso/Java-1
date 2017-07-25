package hospital.core.commands;

import hospital.annotations.Command;
import hospital.entities.Medicament;
import hospital.services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Component
@Command(name = "insert medicament")
public class InsertMedicamentCommand extends BaseCommand {

    @Autowired
    private MedicamentService medicamentService;

    @Override
    public void execute() throws IllegalAccessException {

        super.getWriter().writeLine("Name:");
        String name = super.getReader().readLine();

        Medicament medicament = new Medicament();
        medicament.setName(name);

        this.medicamentService.create(medicament);
        super.getWriter().writeLine("Medicament insert successfully.");
    }
}
