import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
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
import javafx.stage.Stage;

public class buttons extends Application {

  ObservableList<Section> sections;
  Button previous = new Button("Previous");
  Button saveSchdule = new Button("Save Schedule");

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    System.out.println(Font.getFontNames());
    primaryStage.setTitle("Course Offering");

    BorderPane originPane = new BorderPane();
    originPane.setStyle("-fx-background-color: #003865;");
    originPane.setPadding(new Insets(10, 10, 10, 30));

    GridPane schedule = new GridPane();
    schedule.setGridLinesVisible(true);

    int rowCount = 12;
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

    // setting the first row (the days)

    Text time = new Text("Time");
    time.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
    time.setTextAlignment(TextAlignment.CENTER);
    Text sunday = new Text("Sunday");
    sunday.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
    Text monday = new Text("monday");
    monday.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
    Text tuesday = new Text("tuesday");
    tuesday.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
    Text wednesday = new Text("wednesday");
    wednesday.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
    Text thursday = new Text("thursday");
    thursday.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));

    // adding the days to the gridpane

    schedule.add(time, 0, 0);
    schedule
        .setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), new CornerRadii(0), new Insets(0))));
    schedule.add(sunday, 1, 0);
    schedule.add(monday, 2, 0);
    schedule.add(tuesday, 3, 0);
    schedule.add(wednesday, 4, 0);
    schedule.add(thursday, 5, 0);

    // setting the times column .

    Text sevenAM = new Text("7 AM");
    sevenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text eightAM = new Text("8 AM");
    eightAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text nineAM = new Text("9 AM");
    nineAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text TenAM = new Text("10 AM");
    TenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text elevenAM = new Text("11 AM");
    elevenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text TwelvePM = new Text("12 PM");
    TwelvePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text onePM = new Text("1 PM");
    onePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text twoPM = new Text("2 PM");
    twoPM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text threePM = new Text("3 PM");
    threePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text fourPM = new Text("4 PM");
    fourPM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
    Text fivePM = new Text("5 PM ");
    fivePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));

    // adding the column to the gridpane
    schedule.add(sevenAM, 0, 1);
    schedule.add(eightAM, 0, 2);
    schedule.add(nineAM, 0, 3);
    schedule.add(TenAM, 0, 4);
    schedule.add(elevenAM, 0, 5);
    schedule.add(TwelvePM, 0, 6);
    schedule.add(onePM, 0, 7);
    schedule.add(twoPM, 0, 8);
    schedule.add(threePM, 0, 9);
    schedule.add(fourPM, 0, 10);
    schedule.add(fivePM, 0, 11);

    schedule.setPadding(new Insets(0, 10, 10, 30));

    // TableView<Section> basket = new TableView<>();
    // TableColumn<Section,String> offeredCourse = new TableColumn<>("Offered
    // Courses");
    // offeredCourse.setMinWidth(300);

    // basket.getColumns().add(offeredCourse);

    // originPane.setRight(basket);

    // Setting side pane
    VBox sidePagePane = new VBox();
    sidePagePane.setSpacing(10);
    sidePagePane.setPadding(new Insets(0, 10, 20, 10));

    // Setting the previous button

    previous.setPrefWidth(250);
    sidePagePane.getChildren().add(previous);
    sidePagePane.setAlignment(Pos.BOTTOM_CENTER);
    originPane.setRight(sidePagePane);
    BorderPane.setAlignment(sidePagePane, Pos.BOTTOM_CENTER);

    StackPane nextButtoPane = new StackPane();
    BorderPane.setAlignment(saveSchdule, Pos.TOP_CENTER);
    saveSchdule.setPrefHeight(45);
    saveSchdule.setPrefWidth(100);
    nextButtoPane.getChildren().add(saveSchdule);
    nextButtoPane.setPadding(new Insets(10, 10, 0, 10));
    StackPane.setAlignment(saveSchdule, Pos.TOP_CENTER);
    sidePagePane.getChildren().add(nextButtoPane);

    ScrollPane scroller = new ScrollPane();

    VBox box = new VBox();
    Button bbb = new Button();
    VBox box2 = new VBox();
    box2.setAlignment(Pos.BASELINE_CENTER);
    box2.getChildren().addAll(new Text("ICS 108 - 02"), new Text("12 - 12:50"), new Text("Dr Rahad"),
        new Text("U T D"));
    bbb.setMinHeight(80);
    bbb.setMinWidth(300);
    bbb.setGraphic(box2);
    box.getChildren().addAll(bbb);
    scroller.setContent(box);
    scroller.setMinHeight(1200);
    sidePagePane.getChildren().add(scroller);

    originPane.setRight(sidePagePane);

    originPane.setCenter(schedule);
    Scene scene = new Scene(originPane, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
