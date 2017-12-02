package finalProgect.services;

import finalProgect.dao.HotelDAO;
import finalProgect.entity.Hotel;


public class HotelService {
    private HotelDAO hotelDAO = new HotelDAO();

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelDAO.addHotel(hotel);
    }
}
