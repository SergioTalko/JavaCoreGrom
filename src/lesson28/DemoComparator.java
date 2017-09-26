package lesson28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "1", false, new Date(400000000));
        Capability capability2 = new Capability(1005, "test", "1", false, new Date(300000000));
        Capability capability3 = new Capability(900, "test", "1", true, new Date(100000000));
        Capability capability4 = new Capability(900, "test", "1", false, new Date(2000000000));


        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        // capabilities.sort(new IsActiveComparator());
        // capabilities.sort(new FullComparator());
        capabilities.sort(new DateComparator());
        System.out.println(capabilities);


        //метод створення компаратора через new
        /*Comparator<Capability> comparator = new Comparator<Capability>() {
            //Якщо channelName не дорівнюють - порівнюю по ньому;
            //Якщо channelName рівні - переходжу до fingerPrint;
            //Якщо fingerPrint не дорівнюють - порівнюю по ньому;
            //Якщо fingerPrint рівні - переходжу до dateCreated;
            //Якщо dateCreated не дорівнюють - порівнюю по ньому;
            //Якщо dateCreated рівні - обєкти рівні;


            @Override
            public int compare(Capability o1, Capability o2) {
                return 0;
            }
        };*/
    }


}
