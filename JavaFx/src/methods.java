import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

class methods {

    public static void saveScheduel(ArrayList<Section> binaryBasket, String filePath) {
        System.out.println("file has been written");

        File file = new File(filePath);
        try (FileOutputStream fileObject = new FileOutputStream(file);
                ObjectOutputStream output = new ObjectOutputStream(fileObject)) {

            output.writeObject(binaryBasket);

            System.out.println("file has been written");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Section> importSavedFile(ArrayList<Section> binaryBasket,
            File file) {

        try (FileInputStream fileObject = new FileInputStream(file);
                ObjectInputStream input = new ObjectInputStream(fileObject)) {

            ArrayList<Section> sections = (ArrayList<Section>) input.readObject();
            System.out.println("has been collected");
            return sections;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();

    }

    public static String getSectionInfo(String courseShortName, String sectionNumber, String days,
            String time) {
        return courseShortName + "-" + sectionNumber + " " + days + " " + time;
    }

    public static void refreshlist(VBox sidePagePane, ListView<String> basketListView) {
        sidePagePane.getChildren().add(basketListView);
        System.out.println("presses");

    }

    class addSectionHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            // e.getSource().get
            System.out.println("add is pressed");
        }
    }

    public static boolean isConflicant(Section addedSection, ArrayList<Section> schedualBasket) {
        if (checkNameConflict(schedualBasket, addedSection))
            return true;

        for (Section section : schedualBasket) {
            if ((checkDayConflict(section, addedSection)) && (checkTimeConflict(section, addedSection)))
                return true;

        }
        return false;

    }

    public static boolean checkNameConflict(ArrayList<Section> schedule, Section subject) {

        for (int i = 0; i < schedule.size(); i++) {

            if (subject.getCourseName().equals(schedule.get(i).getCourseName()))
                return true;
        }
        return false;

    }

    public static boolean checkDayConflict(Section section1, Section section2) {
        char[] daysArray1 = section1.getDays().toCharArray();
        char[] daysArray2 = section2.getDays().toCharArray();

        for (int i = 0; i < daysArray1.length; i++) {
            for (int j = 0; j < daysArray2.length; j++) {
                if (daysArray1[i] == daysArray2[j])
                    return true;
            }
        }

        return false;

    }

    public static boolean checkTimeConflict(Section section1, Section section2) {
        return checkTimeConflict(section1.getTime(), section2.getTime());
    }

    public static boolean checkTimeConflict(String section1, String section2) {
        int startHour1 = Integer.parseInt(section1.split("-")[0]);
        int endHour1 = Integer.parseInt(section1.split("-")[1]);

        System.out.println(startHour1 + "  " + endHour1);

        int startHour2 = Integer.parseInt(section2.split("-")[0]);
        int endHour2 = Integer.parseInt(section2.split("-")[1]);

        System.out.println(startHour2 + "  " + endHour2);

        if (startHour1 >= startHour2 && startHour1 <= endHour2)
            return true;

        if (endHour1 >= startHour2 && endHour1 <= endHour2)
            return true;

        return false;
    }

    public static String generateRandomColor(){
        String[] colors = {"73FBFD", "77FF90", "F58EFF", "FFFE91", "FF8585", "FFAD76", "B4FFAA"};

        int randomIndex = (int) (Math.random()*colors.length + 1);

        return colors[randomIndex];
    }

}
