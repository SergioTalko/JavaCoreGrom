package lesson34.copy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) {

    }

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        checkBeforeCopy(fileFromPath, fileToPath);

        File from = new File(fileFromPath);
        File to = new File(fileToPath);

        try {
            Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Smth going wrong");
        }
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {

        checkBeforeCopy(fileFromPath, fileToPath);

        try {
            FileUtils.copyFile(new File(fileFromPath), (new File(fileToPath)));
        } catch (IOException e) {
            System.err.println("Smth going wrong");
        }
    }

    private static void checkBeforeCopy(String fileFromPath, String fileToPath) throws Exception {

        if (fileFromPath == null || fileToPath == null) throw new NullPointerException("Path to file is null");

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) throw new FileNotFoundException("File with path " + fileFrom + " is not available");

        if (!fileTo.exists())
            throw new FileNotFoundException("File with path " + fileTo + " not available");

        if (!fileFrom.canRead()) throw new Exception("Can't read file with path " + fileFrom);

        if (!fileTo.canWrite()) throw new Exception("Can't write to file with path " + fileTo);

    }

}
