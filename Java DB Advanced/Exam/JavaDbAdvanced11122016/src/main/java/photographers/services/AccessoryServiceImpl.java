package photographers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photographers.dtos.bindings.accessories.AccessoryImportDto;
import photographers.dtos.utility.PhotographerIdUtilityDto;
import photographers.entities.Accessory;
import photographers.entities.Photographer;
import photographers.io.Writer;
import photographers.repositories.AccessoryRepository;
import photographers.repositories.PhotographerRepository;
import photographers.utilities.MapperConverter;
import photographers.utilities.RandomNumber;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AccessoryServiceImpl implements AccessoryService {
    private static final String SUCCESSFULLY_IMPORTED_ACCESSORY_MESSAGE = "Successfully imported %s";

    private final AccessoryRepository accessoryRepository;
    private final PhotographerRepository photographerRepository;
    private final MapperConverter mapperConverter;
    private final Writer writer;

    @Autowired
    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository, MapperConverter mapperConverter, Writer writer) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
        this.mapperConverter = mapperConverter;
        this.writer = writer;
    }

    @Override
    public List<Accessory> findAll() {
        return this.accessoryRepository.findAll();
    }

    @Override
    public Accessory findById(long id) {
        return this.accessoryRepository.findOne(id);
    }

    @Override
    public Accessory createOne(Accessory accessory) {
        return this.accessoryRepository.save(accessory);
    }

    @Override
    public List<Accessory> createMany(Iterable<AccessoryImportDto> accessoryImportDtos) {
        List<Photographer> photographers = this.photographerRepository.findAll();
        PhotographerIdUtilityDto[] photographerIdUtilityDtos = this.mapperConverter.convert(photographers, PhotographerIdUtilityDto[].class);

        List<Accessory> savedAccessories = new ArrayList<>();
        for (AccessoryImportDto accessoryImportDto : accessoryImportDtos) {
            accessoryImportDto.setAccessoryOwner(photographerIdUtilityDtos[RandomNumber.getRandomNumber(photographerIdUtilityDtos.length - 1)]);
            Accessory accessory = this.mapperConverter.convert(accessoryImportDto, Accessory.class);
            this.createOne(accessory);
            this.writer.println(SUCCESSFULLY_IMPORTED_ACCESSORY_MESSAGE, accessory.getName());
            savedAccessories.add(accessory);
        }
        return savedAccessories;
    }

    @Override
    public Accessory updateOne(Accessory accessory) {
        return this.accessoryRepository.save(accessory);
    }

    @Override
    public List<Accessory> updateMany(Iterable<Accessory> accessorys) {
        return this.accessoryRepository.save(accessorys);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.accessoryRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByAccessory(Accessory accessory) {
        this.accessoryRepository.delete(accessory);
    }

}
