package photographers.services;

import photographers.dtos.bindings.accessories.AccessoryImportDto;
import photographers.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> findAll();

    Accessory findById(long id);

    Accessory createOne(Accessory accessory);

    List<Accessory> createMany(Iterable<AccessoryImportDto> accessoryImportDtos);

    Accessory updateOne(Accessory accessory);

    List<Accessory> updateMany(Iterable<Accessory> accessorys);

    void deleteById(long id);

    void deleteByAccessory(Accessory accessory);
}
