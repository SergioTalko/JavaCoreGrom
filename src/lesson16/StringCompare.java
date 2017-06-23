package lesson16;

public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));
        System.out.println("abc" == "abc");
        System.out.println("Abc".equals("abc"));

        String s1 = "test";
        String s2 = "test";



        /*test.getBytes();
        test.equals("eee");
        test.intern();*/
    }
}
