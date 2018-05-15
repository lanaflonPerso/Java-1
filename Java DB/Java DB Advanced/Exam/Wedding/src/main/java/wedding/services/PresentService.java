package wedding.services;

import wedding.dtos.bindings.present.PresentImportFromXmlDto;
import wedding.entities.Present;

import java.util.List;

public interface PresentService {

    Present createOne(PresentImportFromXmlDto presentImportFromXmlDto);

    List<Present> createMany(Iterable<Present> presents);

}
