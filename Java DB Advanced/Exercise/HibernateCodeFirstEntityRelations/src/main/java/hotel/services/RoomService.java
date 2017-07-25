package hotel.services;

import hotel.entities.Room;

import java.util.List;

public interface RoomService {

    List<Room> findAll();

    Room findById(long id);

    Room create(Room room);

    List<Room> multipleCreate(Iterable<Room> rooms);

    void deleteById(long id);
}
