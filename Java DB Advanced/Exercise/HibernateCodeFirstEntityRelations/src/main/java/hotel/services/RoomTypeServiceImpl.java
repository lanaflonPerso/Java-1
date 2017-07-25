package hotel.services;

import hotel.entities.RoomType;
import hotel.repositories.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomtypeRepository;

    @Autowired
    public RoomTypeServiceImpl(RoomTypeRepository roomtypeRepository) {
        this.roomtypeRepository = roomtypeRepository;
    }

    @Override
    public List<RoomType> findAll() {
        return this.roomtypeRepository.findAll();
    }

    @Override
    public RoomType findById(long id) {
        return this.roomtypeRepository.findOne(id);
    }

    @Override
    public RoomType create(RoomType roomtype) {
        return this.roomtypeRepository.save(roomtype);
    }

    @Override
    public List<RoomType> multipleCreate(Iterable<RoomType> roomtypes) {
        return this.roomtypeRepository.save(roomtypes);
    }

    @Override
    public void deleteById(long id) {
        this.roomtypeRepository.delete(id);
    }

}
