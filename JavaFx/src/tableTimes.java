import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class tableTimes {
    static Text[] generateTableTimes() {
        Text sevenAM = new Text("7 ");
        sevenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text eightAM = new Text("8 ");
        eightAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text nineAM = new Text("9 ");
        nineAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text TenAM = new Text("10 ");
        TenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text elevenAM = new Text("11 ");
        elevenAM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text TwelvePM = new Text("12");
        TwelvePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text onePM = new Text("1");
        onePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text twoPM = new Text("2 ");
        twoPM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text threePM = new Text("3");
        threePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text fourPM = new Text("4 ");
        fourPM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text fivePM = new Text("5 ");
        fivePM.setFont(Font.font("MonoSpaced", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 18));
        Text[] texts = { sevenAM, new Text(), new Text(), new Text(), eightAM, new Text(), new Text(), new Text(),
                nineAM, new Text(), new Text(), new Text(), TenAM, new Text(), new Text(), new Text(), elevenAM,
                new Text(), new Text(), new Text(), TwelvePM, new Text(), new Text(), new Text(), onePM, new Text(),
                new Text(), new Text(),
                twoPM, new Text(), new Text(), new Text(), threePM, new Text(), new Text(), new Text(), fourPM,
                new Text(), new Text(), new Text(), fivePM };
        return texts;
    }
}
