import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class tableDays {
    static Text[] generateTableDays() {
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
        Text[] days = { sunday, monday, tuesday, wednesday, thursday };
        return days;
    }
}
