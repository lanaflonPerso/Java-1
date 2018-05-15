package hospital.core.commands;

import hospital.annotations.Command;
import hospital.entities.Diagnose;
import hospital.services.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Component
@Command(name = "insert visitation")
public class InsertDiagnoseCommand extends BaseCommand {

    @Autowired
    private DiagnoseService diagnoseService;

    @Override
    public void execute() throws IllegalAccessException {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            super.getWriter().writeLine("Name:");
            String name = super.getReader().readLine();
            super.getWriter().writeLine("Comments:");
            String comments = super.getReader().readLine();

            Diagnose diagnose = new Diagnose();
            diagnose.setName(name);
            diagnose.setComments(comments);

            this.diagnoseService.create(diagnose);
            super.getWriter().writeLine("Diagnose insert successfully.");

    }
}