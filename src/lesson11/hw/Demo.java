package lesson11.hw;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by SERGIO on 05.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1, 100, 1, new Date(), "Continental", "Rome");
        Room room2 = new Room(2, 200, 2, new Date(), "Continental", "Rome");
        Room room3 = new Room(3, 200, 1, new Date(), "Continental", "Rome");
        Room room4 = new Room(4, 400, 4, new Date(), "Continental", "Rome");
        Room room5 = new Room(5, 90, 3, new Date(), "Continental", "Rome");


        Room[] rooms = {room1, room2, room3, room4, room5};
        Room[] rooms1 = {room5};
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        API[] array = {googleAPI, bookingComAPI, tripAdvisorAPI};


        Controller controller = new Controller(array);
        Room[] checkRoom = controller.requestRooms(100, 1, "Rome", "Continental");
        System.out.println(Arrays.toString(checkRoom));

        //System.out.println(googleAPI.findRooms(100,1,"1", "1"));
        //System.out.println(bookingComAPI.findRooms(200, 1 , "1", "1"));


        //Room[] f = tripAdvisorAPI.findRooms(90,2,"1","1");
        // System.out.println(f[0].getId());


        //Room[] f = tripAdvisorAPI.findRooms(90,2,"1","1");
        //System.out.println(f.length);
        //System.out.println();


        //Room[] f = googleAPI.findRooms(100,1,"1","1");
        //System.out.println(f[0].getId());


    }

}
