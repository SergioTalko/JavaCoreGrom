package finalProgect.services;

import finalProgect.controller.UserController;
import finalProgect.controller.UserLogin;
import finalProgect.dao.HotelDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.UserType;

import java.nio.file.AccessDeniedException;


public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();


    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelDAO.addHotel(hotel);
    }

    public void deleteHotel(Hotel hotel) throws Exception {
        hotelDAO.deleteHotel(hotel);
    }

    public Hotel findHoteByName(String name) throws Exception {
        return hotelDAO.findHoteByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        return hotelDAO.findHotelByCity(city);

    }
}
