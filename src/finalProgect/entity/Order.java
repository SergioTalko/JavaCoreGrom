package finalProgect.entity;

import finalProgect.exceptions.FormatDataInDatabaseException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Order {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        long random = new Random().nextInt(100000) + 10000;
        this.id = random;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public String toString() {
        return id + "," + user.toString().replace(",", ":") + "," + room.toString().replace(",", ":") + "," + dateFormat.format(dateFrom) + "," + dateFormat.format(dateTo) + "," + moneyPaid;

    }



    public static Order createObjectFromString(String stringOrder) throws FormatDataInDatabaseException, ParseException {
        String[] orderFields = stringOrder.split(",");
        if (orderFields.length != 6) throw new FormatDataInDatabaseException("Please check data in DB");
        String changeCharsUser = orderFields[1].replace(":", ",");
        String changeCharsRoom =   orderFields[2].replace(":", ",");

       // System.out.println(changeCharsRoom.length());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        long id = Long.parseLong(orderFields[0]);
        User user = User.createObjectFromString(changeCharsUser);
        Room room = Room.createObjectFromString(changeCharsRoom);
        Date dateFrom = df.parse(orderFields[3]);
        Date dateTo = df.parse(orderFields[4]);
        double moneyPaid = Double.parseDouble(orderFields[5]);


        Order order = new Order(user, room, dateFrom, dateTo, moneyPaid);
        order.setId(id);
        return order;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}

