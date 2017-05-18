package lesson11.hw;

/**
 * Created by SERGIO on 05.05.2017.
 */
public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();

}
