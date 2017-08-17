package lesson23;

public /*final*/ class Validator {

    private String name;
    private final static int checkCount = 10;


    public Validator(String name) {
        this.name = name;

    }

    /*public void test(){
        checkCount =10;
    }*/

    public final boolean validate(){
        //
        //logic1
        //



        return false;
    }



    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }



}
