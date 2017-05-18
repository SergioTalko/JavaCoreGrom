package lesson11.interfaceexample;

/**
 * Created by SERGIO on 25.04.2017.
 */
public interface DbProvider {

    void connectToDb();

    void disconnectFromDb();

    void encryptData();

}
