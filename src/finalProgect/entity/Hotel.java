package finalProgect.entity;

import finalProgect.exceptions.FormatDataInDatabaseException;

import java.util.Random;

public class Hotel {

    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    private Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(String name, String country, String city, String street) {
        long random = new Random().nextInt(2000) + 1001;
        this.id = random;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + country + "," + city + "," + street ;

    }


    public static Hotel createObjectFromString(String stringHotel) throws FormatDataInDatabaseException {
        String[] hotelFields = stringHotel.split(",");
        if (hotelFields.length != 5) throw new FormatDataInDatabaseException("Please check data in DB");

        long id = Long.parseLong(hotelFields[0]);
        String name = hotelFields[1];
        String country = hotelFields[2];
        String city = hotelFields[3];
        String street = hotelFields[4];


        Hotel resultHotel = new Hotel(id, name, country, city, street);
        resultHotel.setId(id);
        return resultHotel;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        if (country != null ? !country.equals(hotel.country) : hotel.country != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        return street != null ? street.equals(hotel.street) : hotel.street == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }
}
