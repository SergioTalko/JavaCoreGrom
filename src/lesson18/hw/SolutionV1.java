package lesson18.hw;

public class SolutionV1 {

    public int[] findNumbers(String text) {
        if (text.isEmpty() || text == null) return null;


        int n = 0;
        int index = 0;
        String[] words = text.split(" ");
        int[] res = new int[countNumbers(text)];

        while (n < words.length) {
            try {
                res[index] = Integer.parseInt(words[n]);
                n++;
                index++;

            } catch (Exception e) {
                System.out.println(words[n] + " not a number");
                n++;
            }
        }

        return res;
    }

    private int countNumbers(String text) {
        if (text.isEmpty() || text == null) return 0;

        int count = 0;
        int n = -1;
        String[] words = text.split(" ");

        while (n < words.length) {
            try {
                n++;
                Integer.parseInt(words[n]);
                count++;


            } catch (Exception e) {
            }
        }

        return count;
    }
}
