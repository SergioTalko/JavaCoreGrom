package lesson19.hw;


public class File {
    private long id;
    private String name;
    private String format;
    private long size;


    public File(long id, String name, String format, long size) throws Exception {


        this.id = id;
        this.name = checkLength(this, name);
        this.format = format;
        this.size = size;


    }

    private String checkLength(File file, String name) throws Exception {
        if (name.length() < 11) {
            return name;
        } else throw new Exception("File with id " + file.getId() + " have long name");
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
