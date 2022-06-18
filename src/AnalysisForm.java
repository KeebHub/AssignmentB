
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class AnalysisForm extends Stage {

    private Label AScore, MScore, LScore, HScore, stuList;
    //private Button butAnalysis, butAnalysis2, butAnalysis1;
    private Pane analysisFormPane;
    private Scene examFormScene;
    private HelperFunctions HF = new HelperFunctions();
    private TabPane tbPane;
    private Tab analysis, result;
    private int WR, TO;
    final private int WW, WH;

    public AnalysisForm() {
        tbPane = new TabPane();

        WR = 80;
        WW = 16;
        WH = 9;
        TO = 100; //text offset
        analysisFormPane = new Pane();
        examFormScene = new Scene(tbPane, WW * WR, WH * WR);

        AScore = HF.createLabelParam(analysisFormPane, "Average Score", ((WR * 7)-TO), WR / 4, 30);
        MScore = HF.createLabelParam(analysisFormPane, "Mode Score", ((WR * 7)-TO), 370, 30);
        LScore = HF.createLabelParam(analysisFormPane, "Lowest Score", ((WR * 13)-TO), WR / 4, 30);
        HScore = HF.createLabelParam(analysisFormPane, "Highest Score", ((WR * 13)-TO), 370, 30);
        stuList = HF.createLabelParam(analysisFormPane, "Student Result List", WR/4, WR/4, 30);

        HF.createLineParam(analysisFormPane, WR*4, 0, examFormScene.getHeight(), WR * WH); //First Vertical line next to student list
        HF.createLineParam(analysisFormPane, WR * 10, 0, WR * 10, WR * WH);  //Second Vertical line next to average score
        HF.createLineParam(analysisFormPane, WR * 4, ((WR * WH) / 2), WR * 16, ((WR * WH) / 2));
        analysisFormPane.
        this.setTitle("Registration Form");
        this.setOnCloseRequest(e -> {
            this.hide();
        });

        result = HF.createTabParam(tbPane, analysisFormPane, "Result");
        analysis = HF.createTabParam(tbPane, analysisFormPane, "Analysis");
        result.setClosable(false);
        analysis.setClosable(false);

        this.setScene(examFormScene);

        this.show();
    }

}

/*
Pseudo code for making the name list 
reading from a serialised data file

ListView stuList = new ListView

for i < (data.getLength/rec_size), i++{
    stuPos = file.readInt();
    stuName = readString(file, NAME_SIZE);
    stuResult = readInt();
    stuList.getItems().add(stuPos + stuName + stuResult)
}
    
public static String readString(RandomAccessFile file, int fixedSize) throws IOException {
        String value = "";
        for (int i = 0; i < fixedSize; i++) {
            value += file.readChar();
        }
        return value;
    }
*/

/*
autosize
prefHeight / width
FXML
bind
Grid pane + 
multiple hbox in a vbox
*/