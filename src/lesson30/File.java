package lesson30;

public class File implements Comparable<File> {
    private String name;
    private long size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(File o) {
        int result = 0;
        if (o.getSize() > this.size) {
            result = 1;
        } else if (o.getSize() < this.size) {
            result = -1;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (size != file.size) return false;
        return name != null ? name.equals(file.name) : file.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (size ^ (size >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    public long getSize() {
        return size;
    }
}
