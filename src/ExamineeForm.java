import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Timer;
public class ExamineeForm extends Stage
{
    private Label pageLabel, labTitle;
    private Button butAnalysis,butAnalysis2,butAnalysis1;
    private Pane examFormPane;
    private Scene examFormScene;
    private HelperFunctions helpFunc = new HelperFunctions();
    private Tab analysis, result;
    
    private Timer timerobj = new Timer();
    public ExamineeForm()
    {
        examFormPane = new Pane();
        examFormScene = new Scene(examFormPane,400,600);

        this.setTitle("Examination 2022");
        this.setOnCloseRequest(e->{
            this.hide();
        });
        
        labTitle = helpFunc.createLabelParam(examFormPane, "IT Examination 2022", 30, 30, false);
        


        
        
        
        this.setScene(examFormScene);
        

        
        
        this.show();
    }
    
    public void Timer()
    {
        
    }
    
    
}

