package lesson11.hw;

public class TripAdvisorAPI implements API {
    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int numberOfRoom = 0;
        int index = 0;
        int roomPriceMin = price - 10;
        int roomPriceMax = price + 10;
        int roomPersonsMin = persons - 1;
        int roomPersonsMax = persons + 1;


        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() >= roomPriceMin && rooms[i].getPrice() <= roomPriceMax && rooms[i].getPersons() <= roomPersonsMax && rooms[i].getPersons() >= roomPersonsMin && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FindedRoom = new Room[numberOfRoom];

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() >= roomPriceMin && rooms[i].getPrice() <= roomPriceMax && rooms[i].getPersons() <= roomPersonsMax && rooms[i].getPersons() >= roomPersonsMin && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
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
