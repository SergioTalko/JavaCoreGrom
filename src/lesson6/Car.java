package lesson6;

public class Car {

    public int price;
    public int yearOfManufacturing;
    public String color;
    public String ownerName;
    public double weight;
    public int horsePower;

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

    public void startRun() {
        System.out.println("I am running....");
    }

    public void stopRun() {
        System.out.println("I am stopping....");
    }

    public void changeOwner(String newOwnerName) {

        ownerName = newOwnerName;
    }
}

