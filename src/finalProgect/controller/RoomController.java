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
        if (Session.getUser() == null) throw new AccessDeniedException("You dont login in system");

        if (Session.getUser() != null && Session.getUser().getUserType() == UserType.ADMIN) {
            return roomService.addRoom(room);
        } else {
            throw new AccessDeniedException("User with name " + Session.getUser().getUserName() + "  have not access to this operation");

        }
    }

    public void deleteRoom(Room room) throws Exception {
        if (Session.getUser() == null) throw new AccessDeniedException("You dont login in system");

        if (Session.getUser() != null && Session.getUser().getUserType() == UserType.ADMIN) {
            roomService.deleteRoom(room);
        } else {
            throw new AccessDeniedException("User with name " + Session.getUser().getUserName() + "  have not access to this operation");
        }


    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (Session.getUser() != null) {
            return roomService.findRooms(filter);
        }
        throw new AccessDeniedException("Please login in system");
    }

}
