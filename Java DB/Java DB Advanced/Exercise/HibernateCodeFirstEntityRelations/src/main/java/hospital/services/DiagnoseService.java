package hospital.services;

import hospital.entities.Diagnose;

import java.util.List;

public interface DiagnoseService {

    List<Diagnose> findAll();

    Diagnose findById(long id);

    Diagnose create(Diagnose diagnose);

    List<Diagnose> multipleCreate(Iterable<Diagnose> diagnoses);

    void deleteById(long id);
}
