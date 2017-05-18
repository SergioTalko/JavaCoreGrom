package lesson11.interfaceexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public class OracleDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic to oracle
    }

    @Override
    public void disconnectFromDb() {
        //some logic to oracle

    }

    @Override
    public void encryptData() {
        //some logic to oracle
    }
}
