package lesson24.firstExample;

public class Demo<T> {


   /* private  void printUser(User user){
        //print

    }*/

   /* private  void printSolution(Solution solution){
        //print

    }*/

    /* private  void printChannel(Channel channel){
   //print
    }*/

    public   void print(T t) {
        System.out.println(t);
        //print
    }

    private static void calculatePrice(AbstractOrder abstractOrder) {
        System.out.println(abstractOrder.getPrice());
    }

    /*private static void calculatePrice(SecondOrder secondOrder) {
        Sys.out.println(secondOrder.getPrice());
    }*/

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());


    }

}
