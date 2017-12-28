package finalProgect.entity;

import finalProgect.exceptions.FormatDataInDatabaseException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;


    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");


    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        long random = new Random().nextInt(4000) + 2001;
        this.id = random;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return id + "," + numberOfGuests + "," + price + "," + breakfastIncluded + "," + petsAllowed + "," + df.format(dateAvailableFrom) + "," + hotel.toString().replace(",", ";");


    }

    public static Room createObjectFromString(String stringRoom) throws FormatDataInDatabaseException, ParseException {
        String[] roomFields = stringRoom.split(",");
        if (roomFields.length != 7) throw new FormatDataInDatabaseException("Please check data in DB");
        String changeChars = roomFields[6].replace(";", ",");
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");

        long id = Long.parseLong(roomFields[0]);
        int numberOfGuests = Integer.parseInt(roomFields[1]);
        double price = Double.parseDouble(roomFields[2]);
        boolean breakfastIncluded = Boolean.parseBoolean(roomFields[3]);
        boolean petsAllowed = Boolean.parseBoolean(roomFields[4]);
        Date dateAvailableFrom = df.parse(roomFields[5]);

        Hotel hotel = Hotel.createObjectFromString(changeChars);


        Room room = new Room( numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel);
        room.setId(id);
        return room;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return id == room.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
