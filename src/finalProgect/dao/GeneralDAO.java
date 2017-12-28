package finalProgect.dao;


import java.io.*;
import java.util.ArrayList;

public abstract class GeneralDAO<T> {

    private String path;
    

    public T add(T t) throws Exception {

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

    public void delete(T t) throws Exception {

        ArrayList<T> data = getAll();

        StringBuffer backup = readFile(path);
        StringBuffer deletedFile = new StringBuffer();


        boolean flag = false;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            for (T t1 : data) {
                if (t1 != null && !t1.equals(t)) {
                    if (!flag) {
                        bufferedWriter.append(t1.toString());
                        flag = true;
                    } else {
                        bufferedWriter.newLine();
                        bufferedWriter.append(t1.toString());
                    }

                }
            }

        } catch (IOException e) {
            writeFile(path, backup, false);
            System.err.println("Smth going wrong please try again later");
        }
    }

    public void update(T t) throws Exception {

        ArrayList<T> data = getAll();

        StringBuffer backup = readFile(path);
        StringBuffer updatedFile = new StringBuffer();


        boolean flag = false;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            for (T t1 : data) {
                if (t1 != null && t1.equals(t)) {
                    if (!flag) {
                        bufferedWriter.append(t.toString());
                        flag = true;
                    } else {
                        bufferedWriter.newLine();
                        bufferedWriter.append(t1.toString());
                    }

                }
            }

        } catch (IOException e) {
            writeFile(path, backup, false);
            System.err.println("Smth going wrong please try again later");
        }
    }


    private static StringBuffer readFile(String path) throws Exception {

        StringBuffer stringToWrite = new StringBuffer();
        String dataFromLine;


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((dataFromLine = br.readLine()) != null) {
                stringToWrite = stringToWrite.append("\r\n").append(dataFromLine);
            }
            if (stringToWrite.length() > 1) {
                stringToWrite = new StringBuffer(stringToWrite.substring(1));
            }
        } catch (IOException e) {
            throw new IOException("Can't read file with path  " + path);
        }
        return stringToWrite;
    }

    private static void writeFile(String path, StringBuffer content, boolean isAppend) throws Exception {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend))) {
            bufferedWriter.append(content);
        } catch (IOException e) {
            throw new IOException("Can't write file with path  " + path);
        }
    }


    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
