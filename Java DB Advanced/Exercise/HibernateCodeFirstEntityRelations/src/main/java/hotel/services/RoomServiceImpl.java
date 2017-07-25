package hotel.services;

import hotel.entities.Room;
import hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room findById(long id) {
        return this.roomRepository.findOne(id);
    }

    @Override
    public Room create(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public List<Room> multipleCreate(Iterable<Room> rooms) {
        return this.roomRepository.save(rooms);
    }

    @Override
    public void deleteById(long id) {
        this.roomRepository.delete(id);
    }

}
