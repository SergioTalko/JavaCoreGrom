package finalProgect.controller;

import finalProgect.services.OrderService;

import java.nio.file.AccessDeniedException;

public class OrderController {

    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId) throws Exception {
        if (Session.getUserInSession() != null) {
            orderService.bookRoom(roomId, userId);
        }
        throw new AccessDeniedException("Please login in system");
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        if (Session.getUserInSession() != null) {
            orderService.cancelReservation(roomId, userId);
        }
        throw new AccessDeniedException("Please login in system");
    }
}
