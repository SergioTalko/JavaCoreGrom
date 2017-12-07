package finalProgect.dao;

import finalProgect.entity.Room;

import java.util.ArrayList;

public class RoomDAO  extends GeneralDAO<Room>{

    public static final String ROOM_DB = "E://data//RoomDB.txt";

    public  Room addRoom(Room room) throws Exception {
        return add(ROOM_DB,room);
    }

    @Override
    ArrayList<Room> getAll() throws Exception {
        return null;
    }
}
