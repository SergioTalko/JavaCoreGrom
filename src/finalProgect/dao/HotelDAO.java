package finalProgect.dao;


import finalProgect.controller.UserController;
import finalProgect.controller.UserLogin;
import finalProgect.entity.Hotel;
import finalProgect.entity.User;
import finalProgect.entity.UserType;
import finalProgect.exceptions.BadRequestException;
import lesson20.task1.exception.UserNotFoundException;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;

public class HotelDAO extends GeneralDAO<Hotel> {

     public static final String HOTEL_DB = "E://data//HotelDB.txt";


   public  Hotel addHotel(Hotel hotel) throws Exception {
           return add(HOTEL_DB, hotel);
    }

   public Hotel findHoteByName(String name) throws Exception {
       if (name == null) throw new NullPointerException("Name is null");

       for (Hotel hotel : getAllHotels()){
           if (hotel.getName().equals(name)){
               return hotel;
           }
       }
       throw new Exception("Hotel with name " + name + " not found");
   }


   public ArrayList<Hotel> getAllHotels() throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String stringHotel;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HOTEL_DB))) {
            while ((stringHotel = bufferedReader.readLine()) != null) {
                hotels.add(Hotel.createObjectFromString(stringHotel));
                //TODO
            }

        } catch (IOException e) {
            System.err.println("Method " + getAllHotels() + " is closed.Try again later");
        }catch (NumberFormatException e) {
            System.err.println("Please check data on this path " + HOTEL_DB + " You have wrong format data there");
        }
        return hotels;


    }





}
