import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class App extends Application {
        static GridPane schedule;
        static ArrayList<Lecture> scheduleLectures = new ArrayList<Lecture>();
        static ArrayList<Section> saveSections = new ArrayList<>();
        ArrayList<Section> importedSections = new ArrayList<>();
        static VBox sectionsVBox;
        Scene scene;
        BorderPane rootPane;
        BorderPane rootPane2;

        public void start(Stage stage) {
                // Load data
                ArrayList<Course> degreePlanCourses = new ArrayList<>();
                Student student = new Student(new ArrayList<finishedCourse>());
                ArrayList<Section> sections = new ArrayList<>();
                try {
                        degreePlanCourses = loadData.LoadDegreePlan();
                        student = new Student(loadData.loadFinishedCourses());
                        sections = loadData.LoadCourseOffering(degreePlanCourses, student);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }

                // ################### SCREEN 1 ################### / /

                // Page layout
                stage.setTitle("Course Offereing");
                stage.setMaximized(true);

                // Root Pane
                rootPane = new BorderPane();
                rootPane.setStyle("-fx-background-color: #003865;");
                rootPane.setPadding(new Insets(10, 20, 10, 20));

                // #### top pane children #### start //

                // top page pane
                VBox topPagePane = new VBox();
                topPagePane.setSpacing(10);
                topPagePane.setPadding(new Insets(0, 10, 20, 10));
                rootPane.setTop(topPagePane);

                // title pane
                StackPane titlePane = new StackPane();
                Text title = new Text("Course Offereing");
                title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
                title.setFill(Color.WHITE);
                titlePane.getChildren().add(title);
                titlePane.setPadding(new Insets(10, 10, 10, 10));
                topPagePane.getChildren().add(titlePane);

                // import button pane
                StackPane importButtonPane = new StackPane();
                Button importButton = new Button("Start with a saved Schedule");
                importButton.setAlignment(Pos.CENTER);
                importButton.setPrefWidth(250);
                importButtonPane.getChildren().add(importButton);
                importButtonPane.setAlignment(Pos.BASELINE_RIGHT);
                topPagePane.getChildren().add(importButton);
                topPagePane.setAlignment(Pos.CENTER);

                importButton.setOnAction(e -> {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("open");
                        File initialDirectory = new File("src\\main\\resources");
                        fileChooser.setInitialDirectory(initialDirectory);
                        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("DAT files", "*.dat*"));

                        // Opening a dialog box
                        File file = fileChooser.showOpenDialog(stage);

                        importedSections = methods.importSavedFile(importedSections, file);
                        for (Section section : importedSections) {
                                Lecture lecture = new Lecture();

                                for (int i = 0; i < section.getDays().length(); i++) {
                                        VBox sectionScheduleInfo = new VBox();
                                        sectionScheduleInfo.setMinHeight(75);
                                        Button removeButton = new Button("Remove");
                                        lecture.vboxes.add(sectionScheduleInfo);

                                        removeButton.setOnAction(event -> {
                                                for (VBox vbox : lecture.vboxes) {
                                                        App.schedule.getChildren().remove(vbox);
                                                }
                                                App.scheduleLectures.remove(lecture);

                                        });

                                        sectionScheduleInfo.getChildren().addAll(new Text(section.getCourseShortName()),
                                                        new Text(section.getDays()),
                                                        new Text(section.getTime()), removeButton);
                                        sectionScheduleInfo.setStyle("-fx-background-color: #00ff00;" +
                                                        "-fx-border-radius: 10 10 10 10;" +
                                                        "-fx-background-radius: 10 10 10 10;");
                                        App.schedule.add(sectionScheduleInfo,
                                                        TimeConverter.DaysToIndex(
                                                                        section.getDays().substring(i, i + 1)),
                                                        TimeConverter.TimeToIndex(section.getTime()), 1,
                                                        TimeConverter.TimeToRawSpan(section.getTime()));
                                }
                                App.scheduleLectures.add(lecture);
                        }
                });

                // #### top pane children #### end //

                // next button
                Button nexButton = new Button("next");
                nexButton.setOnAction(e -> scene.setRoot(rootPane2));
                nexButton.setPrefHeight(45);
                nexButton.setPrefWidth(100);

                StackPane nextButtoPane = new StackPane();
                nextButtoPane.getChildren().add(nexButton);
                nextButtoPane.setPadding(new Insets(10, 10, 0, 10));
                nextButtoPane.setAlignment(Pos.BASELINE_RIGHT);
                rootPane.setBottom(nextButtoPane);

                // #### side pane children #### end //

                // Tableview
                TableView<Section> table = new TableView<Section>();
                table.getColumns().addAll(
                                tableColumns.generateTableColumns());
                ObservableList<Section> sectionsList = FXCollections.observableArrayList(sections);
                table.setItems(sectionsList);
                table.setEditable(true);
                rootPane.setCenter(table);

                // ################### SCREEN 2 ################### / /

                // root pane
                rootPane2 = new BorderPane();

                // Schedule grid pane configurations
                schedule = new GridPane();
                rootPane2.setCenter(schedule);

                schedule.setGridLinesVisible(true);
                // schedule.setPadding(new Insets(0, 10, 10, 30));
                int rowCount = 45;
                int columnCount = 6;
                RowConstraints rc = new RowConstraints();
                rc.setPercentHeight(100d / rowCount);
                for (int i = 0; i < rowCount; i++) {
                        schedule.getRowConstraints().add(rc);
                }
                ColumnConstraints cc = new ColumnConstraints();
                cc.setPercentWidth(100d / columnCount);
                for (int i = 0; i < columnCount; i++) {
                        schedule.getColumnConstraints().add(cc);
                }
                Text time = new Text("Time");
                time.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
                time.setTextAlignment(TextAlignment.CENTER);
                schedule.add(time, 0, 0);
                // schedule.setBackground(new Background(
                // new BackgroundFill(Color.rgb(50, 50, 50), new CornerRadii(0), new
                // Insets(0))));

                // adding the days to the gridpane
                schedule.addRow(0, tableDays.generateTableDays());

                // adding the times to the gridpane
                schedule.addColumn(0, tableTimes.generateTableTimes());

                // side page pane2
                VBox sidePagePane2 = new VBox();
                sidePagePane2.setSpacing(10);
                sidePagePane2.setPadding(new Insets(20, 10, 20, 10));
                sidePagePane2.setStyle("-fx-background-color: #003865;");
                rootPane2.setRight(sidePagePane2);
                ScrollPane scrollPane = new ScrollPane();

                // #### side pane2 children #### start //

                // save schedule button
                Button saveSchedule = new Button("save schedule");
                saveSchedule.setPadding(new Insets(10, 0, 10, 0));
                saveSchedule.setOnAction(e -> {
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("Save");
                        fileChooser.setInitialFileName("mySchedual.dat");
                        File initialFolder = new File("src\\main\\resources");
                        fileChooser.setInitialDirectory(initialFolder);
                        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("DAT files", "*.dat*"),
                                        new FileChooser.ExtensionFilter("dat", "*.dat"));
                        // Opening a dialog box
                        try {
                                File file = fileChooser.showSaveDialog(stage);
                                fileChooser.setInitialDirectory(file.getParentFile());
                                String filePath = file.getAbsolutePath();
                                System.out.println(filePath);

                                methods.saveScheduel(saveSections, filePath);
                                System.out.println("Save done");
                        } catch (Exception ex) {
                                // TODO: handle exception
                                System.out.println(ex.getMessage());
                        }

                });
                saveSchedule.setPrefWidth(300);
                sidePagePane2.getChildren().add(saveSchedule);

                // scrollPane

                ScrollPane scroller = new ScrollPane();
                sectionsVBox = new VBox();
                scroller.setContent(sectionsVBox);
                scroller.setMinHeight(650);
                scrollPane.setPadding(new Insets(0, 10, 0, 10));
                sidePagePane2.getChildren().add(scroller);
                

                // previous button
                Button previous = new Button("Previous");
                previous.setOnAction(e -> scene.setRoot(rootPane));
                previous.setPrefWidth(300);
                previous.setPadding(new Insets(10, 0, 10, 0)); 
                sidePagePane2.getChildren().add(previous);

                // #### side pane children2 #### end //

                // scene
                scene = new Scene(rootPane);
                stage.setScene(scene);
                stage.show();

        }

        public static void main(String[] args) {
                launch();
        }
}
