package lesson11.hw;

import java.util.Arrays;
import java.util.Date;

public class DemoTestRequestRoom {
    public static void main(String[] args) {
        Room room1 = new Room(1, 110, 2, new Date(), "Continental", "Rome");
        Room room2 = new Room(2, 100, 2, new Date(), "Continental", "Rome");
        Room room3 = new Room(3, 500, 1, new Date(), "Continental", "Rome");
        Room room4 = new Room(4, 400, 4, new Date(), "Continental", "Rome");
        Room room5 = new Room(5, 90, 3, new Date(), "Continental", "Rome");


        Room[] rooms = {room1, room2, room3, room4, room5};
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        API[] array = {googleAPI, bookingComAPI, tripAdvisorAPI};


        Controller controller = new Controller(array);
        Room[] checkRequestRoom = controller.requestRooms(100, 2, "Rome", "Continental");
        //booking- valid id 1,2
        //trip valid id 1,2,5
        //google valod id 2
        //total 6 rooms
        System.out.println(Arrays.toString(checkRequestRoom));
        System.out.println(checkRequestRoom.length);

    }

}
