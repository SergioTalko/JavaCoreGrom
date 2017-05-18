package lesson11.interfaceexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class PostgreSQLDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic to postgreSQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic to postgreSQL
    }

    @Override
    public void encryptData() {
        //some logic to postgreSQL
    }
}
