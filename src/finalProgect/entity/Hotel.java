package finalProgect.entity;

import java.util.Random;

public class Hotel {

    private long id;
    private String country;
    private String city;
    private String street;

    public Hotel(String country, String city, String street) {
        long random = new Random().nextInt(2000) + 1001;
        this.id = random;
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

    @Override
    public String toString() {
        return id + "," + country + "," + city + "," + street + "\n\r";

    }
}
