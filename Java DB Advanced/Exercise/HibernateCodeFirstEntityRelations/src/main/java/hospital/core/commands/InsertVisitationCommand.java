package hospital.core.commands;

import hospital.annotations.Command;
import hospital.entities.Visitation;
import hospital.services.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Component
@Command(name = "insert visitation")
public class InsertVisitationCommand extends BaseCommand {

    @Autowired
    private VisitationService visitationService;

    @Override
    public void execute() throws IllegalAccessException {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        super.getWriter().writeLine("Date:");
        LocalDate date = LocalDate.parse(super.getReader().readLine(), formatter);
        super.getWriter().writeLine("Comments:");
        String comments = super.getReader().readLine();

        Visitation visitation = new Visitation();
        visitation.setDate(date);
        visitation.setComments(comments);

        this.visitationService.create(visitation);
        super.getWriter().writeLine("Visitation insert successfully.");
    }
}