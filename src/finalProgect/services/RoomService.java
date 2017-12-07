package finalProgect.services;

import finalProgect.dao.RoomDAO;
import finalProgect.entity.Room;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    public Room addRoom(Room room) throws Exception {
        return roomDAO.addRoom(room);
    }
}
