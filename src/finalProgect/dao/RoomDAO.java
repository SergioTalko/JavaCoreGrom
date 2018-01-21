package finalProgect.dao;

import finalProgect.entity.Filter;
import finalProgect.entity.Hotel;
import finalProgect.entity.Room;
import finalProgect.exceptions.FormatDataInDatabaseException;
import lesson22.hw.exception.BadRequestException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RoomDAO extends GeneralDAO<Room> {

    private HotelDAO hotelDAO = new HotelDAO();

    public RoomDAO() {
        super.setPath("E://data//RoomDB.txt");
    }

    public Room addRoom(Room room) throws Exception {
        return add(room);
    }

    @Override
    public ArrayList<Room> getAll() throws Exception {
        return super.getAll();
    }

    public void deleteRoom(Room room) throws Exception {
        delete(room);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {

        ArrayList<Room> filteredRooms = new ArrayList<>();

        for (Room room : getAll()) {
            if (filter.findRoomByFilter(room)) {
                filteredRooms.add(room);
            }
        }

        return filteredRooms;
    }

    public Room findRoomById(long id) throws Exception {

        if (id <= 0) throw new BadRequestException("Please check your id " + id);

        for (Room room : getAll()) {
            if (room.getId() == id) {
                return room;
            }
        }
        throw new BadRequestException("Cant find room with id " + id);
    }

    public void updateRoom(Room room) throws Exception {
        update(room);
    }

    public Room createObjectFromString(String stringRoom) throws Exception {
        String[] roomFields = stringRoom.split(",");
        if (roomFields.length != 7) throw new FormatDataInDatabaseException("Please check data in DB");
        String changeChars = roomFields[6].replace(";", ",");
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

        long id = Long.parseLong(roomFields[0]);
        int numberOfGuests = Integer.parseInt(roomFields[1]);
        double price = Double.parseDouble(roomFields[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(roomFields[3]);
        boolean petsAllowed = Boolean.parseBoolean(roomFields[4]);
        Date dateAvailableFrom = df.parse(roomFields[5]);


        Hotel hotel = hotelDAO.createObjectFromString(changeChars) ;


        Room room = new Room(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
        room.setId(id);
        return room;

    }
}
