package finalProgect.services;

import finalProgect.controller.UserController;
import finalProgect.dao.HotelDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.UserType;


public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();


    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelDAO.addHotel(hotel);
    }

    public Hotel findHoteByName(String name) throws Exception {
        return hotelDAO.findHoteByName(name);
    }
}
