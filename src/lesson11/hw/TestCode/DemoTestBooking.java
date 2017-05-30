package lesson11.hw.TestCode;

import lesson11.hw.BookingComAPI;
import lesson11.hw.Room;

import java.util.Arrays;
import java.util.Date;

public class DemoTestBooking {
    public static void main(String[] args) {
        Room room1 = new Room(1, 100, 1, new Date(), "Continental", "Rome");
        Room room2 = new Room(2, 200, 1, new Date(), "Continental", "Rome");
        Room room3 = new Room(3, 300, 3, new Date(), "Continental", "Rome");
        Room room4 = new Room(4, 400, 4, new Date(), "Continental", "Rome");
        Room room5 = new Room(5, 500, 5, new Date(), "Continental", "Rome");


        Room[] rooms = {room1, room2, room3, room4, room5};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        Room[] check = bookingComAPI.findRooms(100,1,"Rome", "Continental");
        //id 1 and 2 valid
        System.out.println(Arrays.toString(check));
        check = bookingComAPI.findRooms(100,1,"Test", "Continental");
        //wrong city
        System.out.println(Arrays.toString(check));
        check = bookingComAPI.findRooms(100,1,"Rome", "4");
        //wrong hotel
        System.out.println(Arrays.toString(check));

    }
}
