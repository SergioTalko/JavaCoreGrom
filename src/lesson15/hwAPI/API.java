package lesson15.hwAPI;

public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();

}
