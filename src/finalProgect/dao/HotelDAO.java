package finalProgect.dao;


import finalProgect.entity.Hotel;
import finalProgect.exceptions.BadRequestException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HotelDAO extends GeneralDAO<Hotel> {

     public static final String HOTEL_DB = "E://data//HotelDB.txt";


   public  Hotel addHotel(Hotel hotel) throws Exception {
           return add(HOTEL_DB, hotel);
    }

   public Hotel findHoteByName(String name) throws Exception {
       if (name == null) throw new NullPointerException("Name is null");

       for (Hotel hotel : getAll()){
           if (hotel.getName().equals(name)){
               return hotel;
           }
       }
       throw new Exception("Hotel with name " + name + " not found");
   }

    public Hotel findHotelByCity(String city) throws Exception {
        if (city == null) throw new NullPointerException("City is null");

        for (Hotel hotel : getAll()){
            if (hotel.getCity().equals(city)){
                return hotel;
            }
        }
        throw new Exception("Hotel with name " + city + " not found");
    }


   public ArrayList<Hotel> getAll() throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String stringHotel;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HOTEL_DB))) {
            while ((stringHotel = bufferedReader.readLine()) != null) {
                hotels.add(Hotel.createObjectFromString(stringHotel));
                //TODO
            }

        } catch (IOException e) {
            System.err.println("Method " + getAll() + " is closed.Try again later");
        }catch (NumberFormatException e) {
            System.err.println("Please check data on this path " + HOTEL_DB + " You have wrong format data there");
        }
        return hotels;


    }

    public void deleteHotel(Hotel hotel) throws Exception {
       delete(HOTEL_DB,hotel);
    }

   /* private Hotel findByName(String name) throws Exception {
        if (name == null) throw new NullPointerException("Name is null");
        for (Hotel hotel : getAll()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("User with name " + name + " not found");
    }*/
    
}
