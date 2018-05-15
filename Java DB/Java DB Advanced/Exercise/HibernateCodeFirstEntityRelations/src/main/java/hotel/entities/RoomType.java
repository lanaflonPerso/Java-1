package hotel.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "room_types")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private long id;

    @Column(name = "room_type")
    private String roomType;

    @Basic
    private String notes;

    public RoomType() {
    }

    public RoomType(String roomType, String notes) {
        this.roomType = roomType;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}