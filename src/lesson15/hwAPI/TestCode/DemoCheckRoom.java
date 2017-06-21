package lesson15.hwAPI.TestCode;

import lesson11.hw.*;

import java.util.Arrays;
import java.util.Date;

public class DemoCheckRoom {
    public static void main(String[] args) {
        Room room1 = new Room(1, 100, 1, null, "Continental", "Rome");
        Room room2 = new Room(2, 600, 2, new Date(), "Continental", "Rome");
        Room room3 = new Room(3, 500, 1, new Date(), "Continental", "Rome");
        Room room4 = new Room(4, 800, 4, new Date(), "Continental", "Rome");
        Room room5 = new Room(5, 90, 3, new Date(), "Continental", "Rome");

        Room room6 = new Room(6, 100, 1, new Date(), "Continental", "Rome");
        Room room7 = new Room(7, 100, 2, new Date(), "Continental", "Rome");
        Room room8 = new Room(8, 500, 1, new Date(), "Continental", "Rome");
        Room room9 = new Room(9, 400, 4, new Date(), "Continental", "Rome");
        Room room10 = new Room(10, 909, 3, null
                , "Continental", "Rome");

        Room room11 = new Room(11, 900, 3, new Date(), "Continental", "Rome");
        Room room12 = new Room(12, 1000, 2, new Date(), "Continental", "Rome");
        Room room13 = new Room(13, 5000, 1, new Date(), "Continental", "Rome");
        Room room14 = new Room(14, 4000, 4, new Date(), "Continental", "Rome");
        Room room15 = new Room(15, 909, 3, new Date(), "Continental", "Rome");


        Room[] rooms = {room1, room2, room3, room4, room5};
        Room[] rooms2 = {room6, room7, room8, room9, room10};
        Room[] rooms3 = {room11, room12, room13, room14, room15};
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms2);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms3);
        API[] array = {googleAPI, bookingComAPI, tripAdvisorAPI};


        Controller controller = new Controller(array);
        Room[] checkRoom = controller.check(bookingComAPI, googleAPI);
        //valid id 6,8
        System.out.println(Arrays.toString(checkRoom));
        System.out.println("");
        checkRoom = controller.check(bookingComAPI, tripAdvisorAPI);
        //valid id 10
        System.out.println(Arrays.toString(checkRoom));
        System.out.println("");
        checkRoom = controller.check(tripAdvisorAPI, googleAPI);
        //немає спільних null
        System.out.println(Arrays.toString(checkRoom));
    }

}
