package finalProgect.controller;

import finalProgect.entity.Hotel;
import finalProgect.entity.UserType;
import finalProgect.services.HotelService;

import java.nio.file.AccessDeniedException;


public class HotelController {
    private HotelService hotelService = new HotelService();


    public Hotel findHoteByName(String name) throws Exception {
        if (UserLogin.getUserName() != null) {
            return hotelService.findHoteByName(name);
        }else
            throw new AccessDeniedException("Please login in system");
    }

   public Hotel findHotelByCity(String city) throws Exception {
       if (UserLogin.getUserName() != null) {
           return hotelService.findHotelByCity(city);
       }else
           throw new AccessDeniedException("Please login in system");
   }

    public void deleteHotel(Hotel hotel) throws Exception {
        hotelService.deleteHotel(hotel);
    }


    public Hotel addHotel(Hotel hotel) throws Exception {
        if (UserLogin.getUserName() != null && UserLogin.getUserType() == UserType.ADMIN) {
            return hotelService.addHotel(hotel);
        }
        if (UserLogin.getUserName() == null) {
            throw new AccessDeniedException("You dont login in system");
        } else {
            throw new AccessDeniedException("User with name " + UserLogin.getUserName() + "  have not access to this operation");
        }
    }


}
