package lesson11.interfaceexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic to mysql
    }

    @Override
    public void disconnectFromDb() {
        //some logic to mysql
    }

    @Override
    public void encryptData() {
        //some logic to mysql
    }
}
