package wedding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wedding.dtos.bindings.present.PresentImportFromXmlDto;
import wedding.entities.Cash;
import wedding.entities.Gift;
import wedding.entities.Invitation;
import wedding.entities.Present;
import wedding.repositories.InvitationRepository;
import wedding.repositories.PresentRepository;
import wedding.utilities.MapperConverter;
import wedding.validators.DTOValidator;

import java.util.List;

@Transactional
@Service
public class PresentServiceImpl implements PresentService {

    private final PresentRepository presentRepository;
    private final InvitationRepository invitationRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public PresentServiceImpl(PresentRepository presentRepository, InvitationRepository invitationRepository, MapperConverter mapperConverter) {
        this.presentRepository = presentRepository;
        this.invitationRepository = invitationRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Present createOne(PresentImportFromXmlDto presentImportFromXmlDto) {
        Present present = null;
        if ("cash".equals(presentImportFromXmlDto.getType())) {
            present = this.mapperConverter.convert(presentImportFromXmlDto, Cash.class);
        } else if ("gift".equals(presentImportFromXmlDto.getType())) {
            present = this.mapperConverter.convert(presentImportFromXmlDto, Gift.class);
        } else {
            return null;
        }
        present.setId(0);

        Invitation invitation = this.invitationRepository.findOne(presentImportFromXmlDto.getInvitationId());
        if (invitation != null) {
            present.setOwner(invitation.getGuest());
            if (DTOValidator.isValid(present)) {
                invitation.setPresent(present);
            }
        }

        if (DTOValidator.isValid(present)) {
            return this.presentRepository.save(present);
        }
        return null;
    }

    @Override
    public List<Present> createMany(Iterable<Present> presents) {
        return this.presentRepository.save(presents);
    }

}
