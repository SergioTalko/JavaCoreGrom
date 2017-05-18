package lesson11.hw;

import java.util.Date;

/**
 * Created by SERGIO on 05.05.2017.
 */
public class BookingComAPI implements API {
    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {


        int numberOfRoom = 0;
        int index = 0;
        int min = price - 100;
        int max = price + 100;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() >= min && rooms[i].getPrice() <= max && persons == rooms[i].getPersons() && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FindedRoom = new Room[numberOfRoom];

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() >= min && rooms[i].getPrice() <= max && persons == rooms[i].getPersons() && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
                FindedRoom[index] = rooms[i];
                index++;
            }

        }

        return FindedRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
