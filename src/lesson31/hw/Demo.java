package lesson31.hw;

public class Demo {
    public static void main(String[] args) throws Exception {

        String string = "";

        System.out.println(Solution.countSymbols("           Hello world          "));
        System.out.println(Solution.countSymbols("           Hello world D          "));
        System.out.println(Solution.countSymbols("           Hello world  GGGGGGGGG         "));
        System.out.println(Solution.countSymbols("           Hello world     HHHHH      "));
        System.out.println(Solution.countSymbols("        555555%6*            "));
        System.out.println(Solution.countSymbols("           ffGG          "));

        System.out.println(Solution.words("45g "));
        System.out.println(Solution.words("45g^ "));
        System.out.println(Solution.words("45g jkgj &&&&&&& ((((( "));
        System.out.println(Solution.words("45g  hello hello hello7"));
        System.out.println(Solution.words("45g hello^ hello( & "));


    }
}
