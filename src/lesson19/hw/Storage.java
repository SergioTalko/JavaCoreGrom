package lesson19.hw;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;


    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) throws Exception {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }


    /*private void checkSameFile(Storage storage, File[] files) throws Exception {

        for (File file1 : storage.getFiles()){
            for (File file2 : storage.getFiles()){
                if (file1 != null && file2 != null && file1.getId() == file2.getId()){
                    throw  new Exception("Two same file in storage");
                }
            }
        }
    }*/

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", files=" + Arrays.toString(files) +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }
}
