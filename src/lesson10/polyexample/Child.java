package lesson10.polyexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class Child extends Human {


    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("Child class is called...");
        super.run();
    }
}
