package hotel.services;

import hotel.entities.RoomType;

import java.util.List;

public interface RoomTypeService {

    List<RoomType> findAll();

    RoomType findById(long id);

    RoomType create(RoomType roomtype);

    List<RoomType> multipleCreate(Iterable<RoomType> roomtypes);

    void deleteById(long id);
}
