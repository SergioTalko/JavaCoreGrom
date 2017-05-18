package lesson11.hw;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by SERGIO on 05.05.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Room room1= new Room(1,100,1,new Date(), "1", "1");
        Room room2 = new Room(2,100,2,new Date(), "1", "1");
        Room room3 = new Room(3,100,3,new Date(), "1", "1");
        Room room4 = new Room(4,100,5,new Date(), "1", "1");
        Room room5 = new Room(5,100,4,new Date(), "1", "1");


        Room[] rooms = {room1, room2,room4, room5};
        Room[] rooms1 = {room2, room1, room3, room5};
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        API[] array = {googleAPI, bookingComAPI, tripAdvisorAPI};


        Controller controller = new Controller(array);
        Room[] r = controller.requestRooms(100,1,"1", "1");
        System.out.println(r[3].getId());

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
