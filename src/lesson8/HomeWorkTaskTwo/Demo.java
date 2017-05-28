package lesson8.HomeWorkTaskTwo;

public class Demo {

    public Student createHighestParent() {

        Student student = new Student("Test", "Test", 1, new Course[]{});

        return student;
    }


    public static Student createLowestChild() {

        SpecialStudent specialStudent = new SpecialStudent("Test", "Test", 1, new Course[]{}, 1, "Test");

        return specialStudent;
    }
}
