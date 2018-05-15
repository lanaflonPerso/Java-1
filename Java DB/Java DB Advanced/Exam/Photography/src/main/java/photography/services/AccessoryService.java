package photography.services;

import photography.dtos.bindings.accessory.AccessoryImportFromXmlDto;
import photography.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> findAll();

    Accessory findById(long id);

    Accessory createOne(Accessory accessory);

    List<Accessory> createMany(Iterable<AccessoryImportFromXmlDto> accessoryImportFromXmlDtos);

    Accessory updateOne(Accessory accessory);

    List<Accessory> updateMany(Iterable<Accessory> accessorys);

    void deleteById(long id);

    void deleteByAccessory(Accessory accessory);
}
