package finalProgect.controller;

import finalProgect.entity.Filter;
import finalProgect.entity.Room;
import finalProgect.entity.UserType;
import finalProgect.services.RoomService;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;

public class RoomController {

    private RoomService roomService = new RoomService();

    public Room addRoom(Room room) throws Exception {
        if (UserLogin.getUserName() != null && UserLogin.getUserType() == UserType.ADMIN) {
            return roomService.addRoom(room);
        }
        if (UserLogin.getUserName() == null) {
            throw new AccessDeniedException("You dont login in system");
        } else {
            throw new AccessDeniedException("User with name " + UserLogin.getUserName() + "  have not access to this operation");
        }
    }

    public void deleteRoom(Room room) throws Exception {
        if (UserLogin.getUserName() != null && UserLogin.getUserType() == UserType.ADMIN) {
            roomService.deleteRoom(room);
        }
        if (UserLogin.getUserName() == null) {
            throw new AccessDeniedException("You dont login in system");
        } else {
            throw new AccessDeniedException("User with name " + UserLogin.getUserName() + "  have not access to this operation");
        }
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }
}
