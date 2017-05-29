package lesson11.hw;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {


        int indexOfRoom = 0;
        for (int i = 0; i < apis.length; i++) {
            if (apis[i].findRooms(price, persons, city, hotel) != null) {
                indexOfRoom += apis[i].findRooms(price, persons, city, hotel).length;
            }
        }

        if (indexOfRoom == 0) {
            return null;
        }

        Room[] result = new Room[indexOfRoom];

        int index = 0;
        for (int i = 0; i < apis.length; i++) {
            if (apis[i].findRooms(price, persons, city, hotel) != null) {
                for (Room room : apis[i].findRooms(price, persons, city, hotel)) {
                    result[index] = room;
                    index++;
                }
            }
        }
        return result;
    }


    public Room[] check(API api1, API api2) {


        Room[] first = api1.getAll();
        Room[] second = api2.getAll();

        int duplicates = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].getPersons() == second[j].getPersons() && first[i].getPrice() == second[j].getPrice() && first[i].getCityName() == second[j].getCityName() && first[i].getHotelName() == second[j].getHotelName()) {
                    duplicates++;
                }
            }
        }
        if (duplicates == 0) {
            return null;
        }

        Room[] checkRoom = new Room[duplicates];

        int indexCheck = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].getPersons() == second[j].getPersons() && first[i].getPrice() == second[j].getPrice() && first[i].getCityName() == second[j].getCityName() && first[i].getHotelName() == second[j].getHotelName()) {
                    checkRoom[indexCheck] = first[i];
                    indexCheck++;
                }
            }
        }
        return checkRoom;
    }

}
