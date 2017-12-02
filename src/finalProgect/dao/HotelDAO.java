package finalProgect.dao;


import finalProgect.entity.Hotel;

public class HotelDAO extends GeneralDAO<Hotel> {

     public static final String HOTEL_DB = "E://data//HotelDB.txt";


   public  Hotel addHotel(Hotel hotel) throws Exception {
      return add(HOTEL_DB, hotel);
    }



}
