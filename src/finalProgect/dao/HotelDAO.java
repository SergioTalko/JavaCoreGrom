package finalProgect.dao;


import finalProgect.entity.Hotel;
import finalProgect.exceptions.BadRequestException;
import finalProgect.exceptions.FormatDataInDatabaseException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HotelDAO extends GeneralDAO<Hotel> {

    public HotelDAO() {
        super.setPath("E://data//HotelDB.txt");
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        return add(hotel);
    }

    public Hotel findHoteByName(String name) throws Exception {
        if (name == null) throw new NullPointerException("Name is null");

        for (Hotel hotel : getAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new Exception("Hotel with name " + name + " not found");
    }

    public Hotel findHotelByCity(String city) throws Exception {
        if (city == null) throw new NullPointerException("City is null");

        for (Hotel hotel : getAll()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new Exception("Hotel with name " + city + " not found");
    }


    public ArrayList<Hotel> getAll() throws Exception {
        return super.getAll();
    }

    public void deleteHotel(Hotel hotel) throws Exception {
        delete(hotel);
    }

    public Hotel findHotelById(long id) throws Exception {

        if (id <= 0) throw new BadRequestException("Please check your id " + id);

        for (Hotel hotel : getAll()) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        throw new BadRequestException("Cant find hotel with id " + id);
    }


    public Hotel createObjectFromString(String stringHotel) throws FormatDataInDatabaseException {
        String[] hotelFields = stringHotel.split(",");
        if (hotelFields.length != 5) throw new FormatDataInDatabaseException("Please check data in DB");

        long id = Long.parseLong(hotelFields[0]);
        String name = hotelFields[1];
        String country = hotelFields[2];
        String city = hotelFields[3];
        String street = hotelFields[4];


        Hotel resultHotel = new Hotel(name, country, city, street);
        resultHotel.setId(id);
        return resultHotel;

    }

}
