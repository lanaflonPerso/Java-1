package hotel.services;

import hotel.entities.RoomStatus;

import java.util.List;

public interface RoomStatusService {

    List<RoomStatus> findAll();

    RoomStatus findById(long id);

    RoomStatus create(RoomStatus roomstatus);

    List<RoomStatus> multipleCreate(Iterable<RoomStatus> roomstatuss);

    void deleteById(long id);
}
