import java.util.ArrayList;

public class Student {
    private ArrayList<finishedCourse> finishedCourses;

    public Student(ArrayList<finishedCourse> finishedCourses) {
        this.finishedCourses = finishedCourses;
    }

    public ArrayList<finishedCourse> getFinishedCourses() {
        return finishedCourses;
    }
}
