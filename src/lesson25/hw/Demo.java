package lesson25.hw;

import java.util.Arrays;

public class Demo {

    /*В классе GeneralDAO реализуйте сохранения объекта в условную базу данных (массив длинной 10) с проверкой всех случаев, а так метод для поиска всех элементов в масиве. Если сохранение невозможно, выбрасывайте ошибку. Используйте общий дженерик для класса. Сигнатура методов: T save(T t) T[] getAll В методе Demo протестируйте методы на как минимум трех разных типах данных*/

    public static void main(String[] args) throws Exception {
        String s = "test";
        String s1 = "test2";
        Long l = new Long(200);
        Integer i = new Integer(100);

        GeneralDAO<String> stringGeneralDAO = new GeneralDAO<>();
        GeneralDAO<Long> longGeneralDAO = new GeneralDAO<>();
        GeneralDAO<Integer> integerGeneralDAO = new GeneralDAO<>();

        stringGeneralDAO.save(s);
        //  stringGeneralDAO.save(s);// same obj
        stringGeneralDAO.save(s1); //space
        System.out.println(Arrays.deepToString(stringGeneralDAO.getAll()));

        longGeneralDAO.save(l);
        System.out.println(Arrays.deepToString(longGeneralDAO.getAll()));

        integerGeneralDAO.save(i);
        System.out.println(Arrays.deepToString(integerGeneralDAO.getAll()));


    }

}
