package lesson25.hw;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];


    public T save(T t) throws Exception {
        if (t == null) throw new Exception("You try save null");

        if (array == null) throw new Exception("Storage " + array + " is null");

        if (t instanceof String && (((String) t).trim()).length() == 0 ) throw new Exception("You save empty string");

        if (!checkFreeSpace())
            throw new Exception("Storage don't have enough free space for save this " + t + " element");

        if (!sameObjInArray(t)) throw new Exception("Storage already have this " + t + " object");


        return saveInArray(t);
    }


    public T[] getAll() throws Exception {

        if (array == null) throw new Exception("Storage is null");

        T[] notNull = countElementInArray();

        if (notNull.length == 0) throw new Exception(array + " array is empty");

        T[] result = arrayWithoutNull();

        return result;
    }

    private boolean checkFreeSpace() {
        for (T obj : array) {
            if (obj == null) {
                return true;
            }
        }


        return false;
    }

    private boolean sameObjInArray(T t) {
        for (T obj : array) {
            if (obj != null && obj.equals(t)) {
                return false;
            }
        }
        return true;
    }

    private T[] countElementInArray() {
        int count = 0;
        for (T obj : array) {
            if (obj != null) {
                count++;
            }
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[count];

        return result;

    }

    private T[] arrayWithoutNull() {

        T[] result = countElementInArray();
        int index = 0;

        for (T obj : array) {
            if (obj != null) {
                result[index] = obj;
                index++;
            }
        }
        return result;
    }

    private T saveInArray(T t) throws Exception {

        int index = 0;
        for (T obj : array) {
            if (obj == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("Please try again later");
    }


}

