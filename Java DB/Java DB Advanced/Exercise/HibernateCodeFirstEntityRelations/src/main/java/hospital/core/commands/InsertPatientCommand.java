package hospital.core.commands;

import hospital.annotations.Command;
import hospital.entities.Diagnose;
import hospital.entities.Medicament;
import hospital.entities.Patient;
import hospital.entities.Visitation;
import hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Component
@Command(name = "insert patient")
public class InsertPatientCommand extends BaseCommand {

    @Autowired
    private PatientService patientService;

    @Override
    public void execute() throws IllegalAccessException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        super.getWriter().writeLine("First name:");
        String firstName = super.getReader().readLine();
        super.getWriter().writeLine("Last name:");
        String lastName = super.getReader().readLine();
        super.getWriter().writeLine("Address:");
        String address = super.getReader().readLine();
        super.getWriter().writeLine("Email:");
        String email = super.getReader().readLine();
        super.getWriter().writeLine("Date of birth:");
        LocalDate dateOfBirth = LocalDate.parse(super.getReader().readLine(), formatter);
        super.getWriter().writeLine("Have you medical insurance? Please answer yes/no:");
        boolean hasMedicalInsurance = false;
        if (super.getReader().readLine().toLowerCase().equals("yes")) {
            hasMedicalInsurance = true;
        }

        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAddress(address);
        patient.setEmail(email);
        patient.setDateOfBirth(dateOfBirth);
        patient.setHasMedicalInsurance(hasMedicalInsurance);

        super.getWriter().writeLine("Visitation:");
        super.getWriter().writeLine("Date:");
        LocalDate date = LocalDate.parse(super.getReader().readLine(), formatter);
        super.getWriter().writeLine("Comments:");
        String visitationComments = super.getReader().readLine();

        Visitation visitation = new Visitation();
        visitation.setDate(date);
        visitation.setComments(visitationComments);
        visitation.setPatient(patient);

        super.getWriter().writeLine("Diagnose:");
        super.getWriter().writeLine("Name:");
        String diagnoseName = super.getReader().readLine();
        super.getWriter().writeLine("Comments:");
        String diagnoseComments = super.getReader().readLine();

        Diagnose diagnose = new Diagnose();
        diagnose.setName(diagnoseName);
        diagnose.setComments(diagnoseComments);
        diagnose.setPatient(patient);

        super.getWriter().writeLine("Medicament:");
        super.getWriter().writeLine("Name:");
        String medicamentName = super.getReader().readLine();

        Medicament medicament = new Medicament();
        medicament.setName(medicamentName);
        medicament.setPatient(patient);

        this.patientService.create(patient);
        super.getWriter().writeLine("Patient insert successfully.");
    }
}
