package finalProgect.controller;

import finalProgect.entity.Hotel;
import finalProgect.services.HotelService;



public class HotelController {
    private HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelService.addHotel(hotel);
    }


}
