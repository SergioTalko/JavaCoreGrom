package finalProgect.dao;

import finalProgect.entity.Filter;
import finalProgect.entity.Room;
import lesson22.hw.exception.BadRequestException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RoomDAO  extends GeneralDAO<Room>{

    public RoomDAO() {
        super.setPath("E://data//RoomDB.txt");
    }

    public  Room addRoom(Room room) throws Exception {
        return add(room);
    }

    @Override
  public   ArrayList<Room> getAll() throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        String stringRoom;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPath()))) {
            while ((stringRoom = bufferedReader.readLine()) != null) {
                rooms.add(Room.createObjectFromString(stringRoom));

            }

        } catch (IOException e) {
            System.err.println("Method " + getAll() + " is closed.Try again later");
        }catch (NumberFormatException e) {
            System.err.println("Please check data on this path " + getPath() + " You have wrong format data there");
        }
        return rooms;


    }

    public void deleteRoom(Room room) throws Exception {
        delete(room);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {

        ArrayList<Room> filteredRooms = new ArrayList<>();

        for (Room room : getAll()){
            if (filter.findRoomByFilter(room)){
                filteredRooms.add(room);
            }
        }

        return filteredRooms;
    }

    public Room findRoomById(long id) throws Exception {

        if (id <= 0) throw new BadRequestException("Please check your id " + id);

        for (Room room : getAll()){
            if (room.getId() == id){
                return room;
            }
        }
        throw new BadRequestException("Cant find room with id " + id);
    }

    public void updateRoom(Room room) throws Exception {
        update(room);
    }
}
