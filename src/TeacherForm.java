import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;

public class TeacherForm extends Stage
{
    private Label labResultTitle, labPerCorr;
    private Button butAnalysis,butAnalysis2,butAnalysis1;
    private Pane analysisFormPane, resultFormPane;
    private Scene analysisFormScene;
    private HelperFunctions helpFunc = new HelperFunctions();
    private TabPane tbPane;
    private Tab analysis, result;
    private TableView table;
    private TableColumn tableColName, tableColStudAns, tableColCorrAns;
    private ComboBox cmbNames;
    private List<User> userLists;
    public TeacherForm()
    {
        tbPane = new TabPane();
        
        analysisFormPane = new Pane();
        analysisFormScene = new Scene(tbPane,800,600);
        this.setScene(analysisFormScene);
        
        this.setTitle("Results and Analysis Form");
        this.setOnCloseRequest(e->{
            this.hide();
        });
        
        // ============= Results pane ============= //
        resultFormPane = new Pane();
        result = helpFunc.createTabParam(tbPane, resultFormPane, "Result");
        labResultTitle = helpFunc.createLabelParam(resultFormPane, "Result Form", 30, 10, false);
        table = new TableView();
        table.setEditable(true);
        
        //Binding height to Scene size (makes it resizable)
        table.prefHeightProperty().bind(this.heightProperty());
        table.prefWidthProperty().bind(this.widthProperty());

        //Setting Columns for table
        tableColName = new TableColumn("Name");
        tableColStudAns = new TableColumn("Answer");
        tableColCorrAns = new TableColumn("Correct Answer");
        
        //Setting minumum width of columns
        tableColName.setMinWidth(500);
        tableColStudAns.setMinWidth(150);
        tableColCorrAns.setMinWidth(150);
        
        //Adding all columns into table
        table.getColumns().addAll(tableColName, tableColStudAns, tableColCorrAns);
       
        //Setting location of table
        table.setLayoutX(0);
        table.setLayoutY(50);
        
        //Adding table to pane
        resultFormPane.getChildren().add(table);
        
        //Adding combobox
        cmbNames = helpFunc.createComboBox(resultFormPane, 600, 10);
        
        
        // ======================================== //
        
        // ============= Analysis pane ============= //
        analysis = helpFunc.createTabParam(tbPane, analysisFormPane, "Analysis");
        
        
        // ======================================== //

        result.setClosable(false);
        analysis.setClosable(false);
        this.show();

    }
    
    public void populateCmbBox()
    {
        userLists = new ArrayList<User>();
        List<String> ansList = new ArrayList<String>();
        Scanner afile;
        String[] lineArray;
        try 
        {
            File file = new File("src/data/exam_answers.txt");
            afile = new Scanner(file);
            while (afile.hasNextLine()) 
            {
                String line = afile.nextLine();
                lineArray = line.split(":");
                
                for(int i = 1; i<=20; i++)
                {
                    ansList.add(lineArray[i]);
                }
                userLists.add(new User(lineArray[0],ansList));
            }
            afile.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("FILE NOT FOUND.");
        }
    }
    
    public void calcPercent()
    {
        
    }
}
