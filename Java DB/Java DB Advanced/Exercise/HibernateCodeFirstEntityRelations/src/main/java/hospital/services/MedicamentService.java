package hospital.services;

import hospital.entities.Medicament;

import java.util.List;

public interface MedicamentService {

    List<Medicament> findAll();

    Medicament findById(long id);

    Medicament create(Medicament medicament);

    List<Medicament> multipleCreate(Iterable<Medicament> medicaments);

    void deleteById(long id);
}
