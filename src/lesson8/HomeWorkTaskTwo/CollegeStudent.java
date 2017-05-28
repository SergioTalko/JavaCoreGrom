package lesson8.HomeWorkTaskTwo;

public class CollegeStudent extends Student {
    String collegeName;
    int rating;
    long id;

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken) {
        super(firstName, lastName, group, coursesTaken);

    }

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken, String collegeName, int rating, long id) {
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;
    }
}
