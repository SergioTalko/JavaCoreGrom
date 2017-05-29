package lesson11.hw;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int numberOfRoom = 0;
        int index = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (price == rooms[i].getPrice() && persons == rooms[i].getPersons() && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
                numberOfRoom++;
            }
        }
        if (numberOfRoom == 0) {
            return null;
        }

        Room[] FindedRoom = new Room[numberOfRoom];

        for (int i = 0; i < rooms.length; i++) {
            if (price == rooms[i].getPrice() && persons == rooms[i].getPersons() && city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
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
