package lesson8.HomeWorkTaskTwo;

/**
 * Created by SERGIO on 05.04.2017.
 */
public class SpecialStudent extends CollegeStudent {
    long secretKey;
    String email;


    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        super(firstName, lastName, group, coursesTaken);
        this.secretKey = secretKey;
        this.email = email;
    }
}
