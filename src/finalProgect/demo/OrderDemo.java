package finalProgect.demo;


import finalProgect.dao.OrderDAO;
import finalProgect.services.OrderService;

public class OrderDemo {
    public static void main(String[] args) throws Exception {
        /*User user = new User("First1", "Test", "UK");
        Hotel hotel = new Hotel("Ritz","Spain", "Madrid", "La Cafe");
        Room room = new Room(10,200.5,false,true, new Date(), hotel);
        Order order = new Order(user,room,new Date(),new Date(),200);*/
        OrderService orderService = new OrderService();
   //    orderService.bookRoom(5986,336);
//        orderService.cancelReservation(5986, 336);
//       orderService.bookRoom(4393,336,2370);
//        orderService.cancelReservation(4845,336,1286);
        //

        OrderDAO orderDAO = new OrderDAO();
        System.out.println(orderDAO.getAll());
    }

}
