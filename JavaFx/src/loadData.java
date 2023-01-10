import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class loadData {

    private static Scene scene;

    public static ArrayList<Course> LoadDegreePlan() throws FileNotFoundException {
        ArrayList<Course> degreePlan = new ArrayList<Course>();

        Scanner sc = new Scanner(new File(
                "src\\DegreePlan.csv"));
        sc.nextLine();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");

            // if there is no prerequisite/corequisite return an empty list
            String[] prerequisite = line[2].split(";");
            String[] corequisite = line[3].split(";");
            degreePlan.add(new Course(line[0].replaceAll("\\s", ""), Integer.valueOf(line[1]),
                    prerequisite[0].equals("None") ? new String[0] : prerequisite,
                    corequisite[0].equals("None") ? new String[0] : corequisite));
        }
        sc.close();
        return degreePlan;
    }

    public static ArrayList<finishedCourse> loadFinishedCourses() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(
                "src\\FinishedCourses.csv"));
        ArrayList<finishedCourse> finishedCourses = new ArrayList<finishedCourse>();
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            finishedCourses.add(new finishedCourse(line[0].replaceAll("\\s", ""), line[1], line[2]));
        }
        sc.close();
        return finishedCourses;
    }

    // assumes that the course offering has only the DegreePlan courses
    public static ArrayList<Section> LoadCourseOffering(ArrayList<Course> degreePlan, Student student)
            throws FileNotFoundException {
        Scanner sc = new Scanner(new File(
                "src\\CourseOffering.csv"));
        ArrayList<Section> sections = new ArrayList<Section>();
        sc.nextLine();

        // put section if not finished and prerequisite satisfied
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            String sectionCourseShortName = (line[0].split("-")[0]).replaceAll("\\s", "");

            boolean finished = false;
            boolean satistfyPrerequisite = false;

            ArrayList<finishedCourse> finishedCourses = student.getFinishedCourses();

            // check if course is finished
            for (finishedCourse course : finishedCourses) {
                if (course.equals(sectionCourseShortName)) {
                    finished = true;
                }
            }

            // check if course has prerequisite satisfied
            // find the course of the section in the degreeplan to get its prerequisites
            for (Course course : degreePlan) {
                if (course.getCourseShortName().equals(sectionCourseShortName)) {
                    // for each prerequisite course, check if it is finished
                    String[] prerequisiteCourses = course.getPrerequisiteCourses();
                    int numberOfPrerequisiteCourses = prerequisiteCourses.length;
                    int counter = 0;
                    for (String prerequisiteCourse : prerequisiteCourses) {
                        for (finishedCourse finishedcourse : finishedCourses) {
                            if (finishedcourse.equals(prerequisiteCourse)) {
                                counter += 1;
                            }
                        }
                    }
                    if (counter == numberOfPrerequisiteCourses) {
                        satistfyPrerequisite = true;
                    }

                }
            }

            if ((finished == false) && (satistfyPrerequisite == true)) {
                Course sectionCourse = null;
                for (Course course : degreePlan) {
                    if (course.getCourseShortName().equals(sectionCourseShortName)) {
                        sectionCourse = course;
                    }

                }
                // screen 1 add remove button
                Button addaButton = new Button();
                addaButton.setText("Add");
                addaButton.setAlignment(Pos.CENTER);
                addaButton.setMinWidth(70);
                addaButton.setStyle("-fx-background-color: #75FA8D");

                // screen 2 sections buttons
                Button sectionButton = new Button();
                VBox sectionInfo = new VBox();
                sectionInfo.setAlignment(Pos.BASELINE_CENTER);
                sectionButton.setMinHeight(80);
                sectionButton.setMinWidth(300);
                sectionButton.setGraphic(sectionInfo);
                sectionInfo.getChildren().addAll(new Text(line[0]), new Text(line[7]), new Text(line[5]),
                        new Text(line[6]));
                Lecture lecture = new Lecture();
                Section section = new Section(sectionCourse, line[0].split("-")[0].replaceAll("\\s", ""),
                        line[0].split("-")[1], line[1],
                        line[2],
                        line[3], line[4], line[5], line[6], line[7], line[8], line[9], addaButton);
                lecture.section = section;
                sectionButton.setOnAction(e -> {
                    boolean add = true;
                    boolean conflict = methods.isConflicant(section, App.saveSections);
                    for (Lecture lec : App.scheduleLectures) {
                        if (lec.section.equals(section)) {
                            add = false;

                        }

                    }

                    if (add && !conflict) {
                        for (int i = 0; i < line[5].length(); i++) {
                            VBox sectionScheduleInfo = new VBox();
                            sectionScheduleInfo.setMinHeight(75);
                            Button removeButton = new Button("Remove");
                            lecture.vboxes.add(sectionScheduleInfo);

                            removeButton.setOnAction(event -> {
                                for (VBox vbox : lecture.vboxes) {
                                    App.schedule.getChildren().remove(vbox);
                                }
                                App.scheduleLectures.remove(lecture);
                                App.saveSections.remove(section);
                            });

                            sectionScheduleInfo.getChildren().addAll(new Text(line[0]),
                                    new Text(line[5]),
                                    new Text(line[6]), removeButton);           //" + methods.generateRandomColor()+ "
                            sectionScheduleInfo.setStyle("-fx-background-color: #9AD2FF;" +
                                    "-fx-border-radius: 10 10 10 10;" +
                                    "-fx-background-radius: 10 10 10 10;");
                            App.schedule.add(sectionScheduleInfo,
                                    TimeConverter.DaysToIndex(line[5].substring(i, i + 1)),
                                    TimeConverter.TimeToIndex(line[6]), 1, TimeConverter.TimeToRawSpan(line[6]));
                        }
                        App.saveSections.add(section);
                        App.scheduleLectures.add(lecture);

                    }
                });

                addaButton.setOnAction(e -> {
                    if (!App.sectionsVBox.getChildren().contains(sectionButton)) {
                        App.sectionsVBox.getChildren().add(sectionButton);
                        addaButton.setText("Remove");
                        addaButton.setStyle("-fx-background-color: #F08784");

                    } else {
                        App.sectionsVBox.getChildren().remove(sectionButton);
                        addaButton.setText("Add");
                        addaButton.setStyle("-fx-background-color: #75FA8D");
                    }
                });

                sections.add(section);

            }
        }

        sc.close();
        return sections;
    }

}