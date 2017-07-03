package lesson18.hw;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        SolutionV1 solutionV1 = new SolutionV1();
        SolutionV2 solutionV2 = new SolutionV2();

        String str = "g 90 7h 5g 7";

        System.out.println(Arrays.toString(solutionV1.findNumbers(str)));
        System.out.println(Arrays.toString(solutionV2.findNumbers(str)));
    }
}
