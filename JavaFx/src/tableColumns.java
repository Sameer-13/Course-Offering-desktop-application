import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableColumns {
        static TableColumn<Section, String>[] generateTableColumns() {
                TableColumn<Section, String> courseCol = new TableColumn<Section, String>("Course");
                courseCol.setMinWidth(75);
                courseCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("courseShortName"));

                TableColumn<Section, String> sectionCol = new TableColumn<Section, String>("Section");
                sectionCol.setMinWidth(75);
                sectionCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("sectionNumber"));

                TableColumn<Section, String> activityCol = new TableColumn<Section, String>("Activity");
                activityCol.setMinWidth(75);
                activityCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("activity"));

                TableColumn<Section, String> crnCol = new TableColumn<Section, String>("CRN");
                crnCol.setMinWidth(100);
                crnCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("crn"));

                TableColumn<Section, String> courseNameCol = new TableColumn<Section, String>("Course Name");
                courseNameCol.setMinWidth(300);
                courseNameCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("courseName"));

                TableColumn<Section, String> instructorCol = new TableColumn<Section, String>("Instructor");
                instructorCol.setMinWidth(225);
                instructorCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("instructor"));

                TableColumn<Section, String> dayCol = new TableColumn<Section, String>("Day");
                dayCol.setMinWidth(100);
                dayCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("days"));

                TableColumn<Section, String> timeCol = new TableColumn<Section, String>("Time");
                timeCol.setMinWidth(100);
                timeCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("time"));

                TableColumn<Section, String> locationCol = new TableColumn<Section, String>("Location");
                locationCol.setMinWidth(100);
                locationCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("location"));

                TableColumn<Section, String> statusCol = new TableColumn<Section, String>("Status");
                statusCol.setMinWidth(115);
                statusCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("status"));

                TableColumn<Section, String> waitlistCol = new TableColumn<Section, String>("Waitlist");
                waitlistCol.setMinWidth(115);
                waitlistCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("waitList"));

                TableColumn<Section, String> addCol = new TableColumn<Section, String>("Add/Remove");
                addCol.setMinWidth(100);
                addCol.setCellValueFactory(
                                new PropertyValueFactory<Section, String>("addButton"));
                TableColumn[] columns = { courseCol, sectionCol, activityCol, crnCol, courseNameCol, instructorCol,
                                dayCol, timeCol, locationCol, statusCol, waitlistCol, addCol };
                return columns;
        }
}