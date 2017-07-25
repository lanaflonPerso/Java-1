package hotel.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private long id;

    @Column(name = "room_number")
    private String roomNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_type_id", foreignKey = @ForeignKey(name = "fk_rooms_room_types"))
    private RoomType roomType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bed_type_id", foreignKey = @ForeignKey(name = "fk_rooms_bed_types"))
    private BedType bedType;

    @Basic
    private double rate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_status_id", foreignKey = @ForeignKey(name = "fk_rooms_room_status"))
    private RoomStatus roomStatus;

    @Basic
    private String notes;

    public Room() {
    }

    public Room(String roomNumber, RoomType roomType, BedType bedType, double rate, RoomStatus roomStatus, String notes) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.rate = rate;
        this.roomStatus = roomStatus;
        this.notes = notes;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BedType getBedType() {
        return this.bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public RoomStatus getRoomStatus() {
        return this.roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}