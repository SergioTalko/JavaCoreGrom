package finalProgect.dao;

import lesson8.ads.BaseEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneralDAO<T> {


    public T add(String path, T t) throws Exception {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {

            if (new File(path).length() == 0) {
                bufferedWriter.append(t.toString());
            } else {
                bufferedWriter.newLine();
                bufferedWriter.append(t.toString());
            }
        } catch (IOException e) {
            System.err.println("Cant save " + t.getClass().getName());
        }

        return t;
    }


}
