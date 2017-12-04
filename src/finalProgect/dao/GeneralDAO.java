package finalProgect.dao;

import finalProgect.entity.User;

import java.io.*;
import java.util.ArrayList;

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

    public T delete(String path, T t){

        //TODO
        return null;
    }



}
