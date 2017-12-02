package finalProgect.demo;

import finalProgect.dao.HotelDAO;
import finalProgect.entity.Hotel;

public class HotelDemo {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel("Spain", "Madrid", "La Cafe");
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.add(HotelDAO.HOTEL_DB,hotel);
    }
}
