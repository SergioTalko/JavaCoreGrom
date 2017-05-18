package lesson8.ads;

import java.util.Date;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class HouseAd extends Ad {
    String ownerName;
    String adress;
    double square;
    int floors;

    public HouseAd(long id, int price, String ownerName, String adress, double square, int floors) {
        super(id, price);
        this.ownerName = ownerName;
        this.adress = adress;
        this.square = square;
        this.floors = floors;
    }

    boolean checkOwner(){
        Owner owners = new Owner();

        for (String owner : owners.owners){
            if(ownerName == owner )
                return true;
        }
        return  false;

    }
}
