import java.io.Serializable;

import javafx.scene.control.Button;

public class Section implements Serializable {

    private Course course;
    private String courseShortName;
    private String sectionNumber;
    private String activity;
    private String crn;
    private String courseName;
    private String instructor;
    private String days;
    private String time;
    private String location;
    private String status;
    private String waitlist;
    private transient Button addButton;

    public Section(Course course, String courseShortName, String sectionNumber, String activity, String crn,
            String courseName, String instructor, String days,
            String time, String location, String status, String waitlist, Button addButton) {
        this.course = course;
        this.courseShortName = courseShortName;
        this.sectionNumber = sectionNumber;
        this.activity = activity;
        this.crn = crn;
        this.courseName = courseName;
        this.instructor = instructor;
        this.days = days;
        this.time = time;
        this.location = location;
        this.status = status;
        this.waitlist = waitlist;
        this.addButton = addButton;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return courseShortName + " -" + sectionNumber + "- " + time + " " + days;
    }

    // getter methods
    public String getActivity() {
        return activity;
    }

    public Course getCourse() {
        return course;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCrn() {
        return crn;
    }

    public String getDays() {
        return days;
    }

    public String getTime() {
        return time;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getLocation() {
        return location;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getWaitList() {
        return waitlist;
    }

    public Button getAddButton() {
        return addButton;
    }

}