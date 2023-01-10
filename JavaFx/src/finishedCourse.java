public class finishedCourse {
    private String courseShortName;
    private String term;
    private String grade;

    finishedCourse(String courseShortName, String term, String grade) {
        this.courseShortName = courseShortName;
        this.term = term;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return ((String) o).equals(this.courseShortName);
        } else {
            return false;
        }
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public String getGrade() {
        return grade;
    }

    public String getTerm() {
        return term;
    }
}
