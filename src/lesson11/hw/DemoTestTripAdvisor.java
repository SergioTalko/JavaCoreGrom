package lesson11.hw;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by SERGIO on 29.05.2017.
 */
public class DemoTestTripAdvisor {
    public static void main(String[] args) {

        Room room1 = new Room(1, 300, 1, new Date(), "Continental", "Rome");
        Room room2 = new Room(2, 110, 1, new Date(), "Continental", "Rome");
        Room room3 = new Room(3, 300, 3, new Date(), "Continental", "Rome");
        Room room4 = new Room(4, 90, 2, new Date(), "Continental", "Rome");
        Room room5 = new Room(5, 100, 3, new Date(), "Continental", "Rome");


        Room[] rooms = {room1, room2, room3, room4, room5};

        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        Room[] check = tripAdvisorAPI.findRooms(100, 2, "Rome", "Continental");
        //id 2,4,5 valid
        System.out.println(Arrays.toString(check));
        check = tripAdvisorAPI.findRooms(100, 2, "Test", "Continental");
        //wrong city
        System.out.println(Arrays.toString(check));
        check = tripAdvisorAPI.findRooms(100, 2, "Rome", "4");
        //wrong hotel
        System.out.println(Arrays.toString(check));
    }
}
