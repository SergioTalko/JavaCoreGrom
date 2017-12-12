package finalProgect.demo;

import finalProgect.controller.RoomController;
import finalProgect.dao.RoomDAO;
import finalProgect.entity.Hotel;
import finalProgect.entity.Room;
import java.util.Date;

public class RoomDemo {

    public static void main(String[] args) throws Exception {
       Hotel hotel = new Hotel("R","R","R","R");
        Room room = new Room(10,200.5,false,true, new Date(), hotel);
        RoomController roomController = new RoomController();
    //    roomController.addRoom(room);



        RoomDAO roomDAO = new RoomDAO();

        roomDAO.deleteRoom(roomDAO.findRoomById(4393));
      //  System.out.println(roomDAO.getAll().get(0).getHotel());

    }
}
