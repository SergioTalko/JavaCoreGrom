package finalProgect.controller;

import finalProgect.entity.Hotel;
import finalProgect.entity.UserType;
import finalProgect.services.HotelService;

import java.nio.file.AccessDeniedException;


public class HotelController {
    private HotelService hotelService = new HotelService();


    public Hotel findHoteByName(String name) throws Exception {
        if (Session.getUser() != null) {
            return hotelService.findHoteByName(name);
        } else
            throw new AccessDeniedException("Please login in system");
    }

    public Hotel findHotelByCity(String city) throws Exception {
        if (Session.getUser() != null) {
            return hotelService.findHotelByCity(city);
        } else
            throw new AccessDeniedException("Please login in system");
    }

    public void deleteHotel(Hotel hotel) throws Exception {
        if (Session.getUser() == null) throw new AccessDeniedException("You dont login in system");

        if (Session.getUser().getUserType() == UserType.ADMIN) {
            hotelService.deleteHotel(hotel);
        } else {
            throw new AccessDeniedException("User with name " + Session.getUser().getUserName() + "  have not access to this operation");


        }
    }


    public Hotel addHotel(Hotel hotel) throws Exception {

        if (Session.getUser() == null) throw new AccessDeniedException("You dont login in system");

        if (Session.getUser() != null && Session.getUser().getUserType() == UserType.ADMIN) {
            return hotelService.addHotel(hotel);
        } else {
            throw new AccessDeniedException("User with name " + Session.getUser().getUserName() + "  have not access to this operation");

        }
    }


}
