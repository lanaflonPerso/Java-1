package wedding.services;

import wedding.dtos.bindings.WeddingsImportFromJsonDto;
import wedding.dtos.views.WeddingGuestListJsonViewDto;
import wedding.entities.Wedding;

import java.util.List;

public interface WeddingService {

    Wedding createOne(WeddingsImportFromJsonDto weddingsImportFromJsonDto);

    List<Wedding> createMany(Iterable<Wedding> weddings);

    List<WeddingGuestListJsonViewDto> getWeddingsGuestList();

    void addVenues();
}
