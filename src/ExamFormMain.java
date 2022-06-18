import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;
public class ExamFormMain extends Application
{
    private Pane mainPane;
    private Scene mainScene;
    private RegistrationForm regisForm;
    private ExamineeForm examForm;
    private TeacherForm tForm;
    public void start(Stage mainStage)
    {
        mainStage.setTitle("Examination Form");
        mainPane = new Pane();
        regisForm = new RegistrationForm();        
        mainScene = new Scene(mainPane,400,600);
        mainStage.setScene(mainScene);
        regisForm.setOnCloseRequest(e->{System.exit(0);});
        regisForm.setOnHiding(e->
        {
            if(regisForm.getCurrUser().getType() == 0)
            {
                tForm = new TeacherForm();
            }
            else
            {
                examForm = new ExamineeForm();
//                this.examForm
            }
        });
        
        
    }
    
    public static void main(String args[])
    {
        Application.launch(args);
    }
}

