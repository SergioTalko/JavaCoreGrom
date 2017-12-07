package finalProgect.dao;

import finalProgect.controller.UserLogin;
import finalProgect.entity.User;
import finalProgect.exceptions.BadRequestException;
import lesson20.task1.exception.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

public abstract class GeneralDAO<T> {


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

    abstract ArrayList<T> getAll() throws Exception;

    public void delete(String path, T t) throws Exception {

        ArrayList<T> data = getAll();
        boolean flag = false;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {


        for (T t1 : data) {
            if (t1 != null && !t1.equals(t)) {
                if (!flag) {
                    bufferedWriter.append(t1.toString());
                    flag = true;
                }else {
                    bufferedWriter.newLine();
                    bufferedWriter.append(t1.toString());
                }
            }
        }

        }catch(IOException e){

        System.err.println("err");

        }
        //TODO
    }


}
