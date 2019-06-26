package models;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    ArrayList<Room> rooms = new ArrayList<>();
    Cities city;

    public Cinema(Cities city) {
        this.city = city;
    }

    public Cities getCity() {
        return city;
    }


    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(String name){
        for (Room room: rooms
             ) {if (room.name.equals(name)){return room;}

        }
    return null;
    }
}
