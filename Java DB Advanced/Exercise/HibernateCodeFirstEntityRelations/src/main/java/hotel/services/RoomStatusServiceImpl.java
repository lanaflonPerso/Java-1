package hotel.services;

import hotel.entities.RoomStatus;
import hotel.repositories.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    private final RoomStatusRepository roomstatusRepository;

    @Autowired
    public RoomStatusServiceImpl(RoomStatusRepository roomstatusRepository) {
        this.roomstatusRepository = roomstatusRepository;
    }

    @Override
    public List<RoomStatus> findAll() {
        return this.roomstatusRepository.findAll();
    }

    @Override
    public RoomStatus findById(long id) {
        return this.roomstatusRepository.findOne(id);
    }

    @Override
    public RoomStatus create(RoomStatus roomstatus) {
        return this.roomstatusRepository.save(roomstatus);
    }

    @Override
    public List<RoomStatus> multipleCreate(Iterable<RoomStatus> roomstatuss) {
        return this.roomstatusRepository.save(roomstatuss);
    }

    @Override
    public void deleteById(long id) {
        this.roomstatusRepository.delete(id);
    }

}
