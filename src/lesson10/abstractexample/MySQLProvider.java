package lesson10.abstractexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class MySQLProvider extends DbProvider {

    @Override
    void connectToDb() {
        //logic for Mysql
    }

    @Override
    void disconnectFromDb() {

    }
}
