package finalProgect.services;

import finalProgect.dao.RoomDAO;
import finalProgect.entity.Filter;
import finalProgect.entity.Room;

import java.util.ArrayList;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    public Room addRoom(Room room) throws Exception {
        return roomDAO.addRoom(room);
    }

    public void deleteRoom(Room room) throws Exception {
        roomDAO.deleteRoom(room);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomDAO.findRooms(filter);
    }
}
