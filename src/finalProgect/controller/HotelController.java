package finalProgect.controller;

import finalProgect.entity.Hotel;
import finalProgect.services.HotelService;



public class HotelController {
    private HotelService hotelService = new HotelService();


    public Hotel findHoteByName(String name) throws Exception {
        return hotelService.findHoteByName(name);
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelService.addHotel(hotel);
    }


}
