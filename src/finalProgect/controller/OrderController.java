package finalProgect.controller;

import finalProgect.services.OrderService;
import lesson22.hw.exception.BadRequestException;

import java.nio.file.AccessDeniedException;

public class OrderController {

    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        if (UserLogin.getUserName() != null) {
            orderService.bookRoom(roomId, userId, hotelId);
        }
        throw new AccessDeniedException("Please login in system");
    }

    public void cancelReservation(long roomId, long userId, long hotelId) throws Exception {
        if (UserLogin.getUserName() != null) {
            orderService.cancelReservation(roomId, userId, hotelId);
        }
        throw new AccessDeniedException("Please login in system");
    }
}
