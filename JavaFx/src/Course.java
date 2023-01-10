import java.io.Serializable;

public class Course implements Serializable {
    private String courseShortName;
    private int creditHours;
    private String[] prerequisiteCourses;
    private String[] corequisiteCourses;

    Course(String courseShortName, int creditHours, String[] prerequisiteCourses, String[] corequisiteCourses) {
        this.courseShortName = courseShortName;
        this.creditHours = creditHours;
        this.prerequisiteCourses = prerequisiteCourses;
        this.corequisiteCourses = corequisiteCourses;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String[] getCorequisiteCourses() {
        return corequisiteCourses;
    }

    public String[] getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

}