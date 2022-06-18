
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;


public class HelperFunctions {
    
    public Label createLabelParam(Pane pane, String text, int x, int y, boolean disable)
    {
        Label label = new Label(text);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setDisable(disable);
        pane.getChildren().add(label);
        return label;
    }
    
    //new param
    public Label createLabelParam(Pane pane, String text, int x, int y,int s)
    {
        Label label = new Label(text);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setFont(new Font("Arial", s));
        pane.getChildren().add(label);
        return label;
    }
    
    //new param
    public Line createLineParam(Pane pane, double x1, int y1, double x2, int y2)
    {
        Line line = new Line();
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        pane.getChildren().add(line);
        return line;
    }
    
    public TextField createTextFieldParam(Pane pane, int x, int y, boolean disable)
    {
        TextField field = new TextField();
        field.setLayoutX(x);
        field.setLayoutY(y);
        field.setDisable(disable);
        pane.getChildren().add(field);
        return field;
    }
    
    public Button createButtonParam(Pane pane, String text, int x, int y, boolean disable)
    {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setDisable(disable);
        pane.getChildren().add(button);
        return button;
    }
    
    public Tab createTabParam(TabPane tbPane, Pane content, String text)
    {
        Tab tab = new Tab();
        tab.setText(text);
        tab.setContent(content);
        tbPane.getTabs().add(tab);
        return tab;
    }
    
    public ComboBox createComboBox(Pane pane, int x, int y)
    {
        ComboBox cmbName = new ComboBox();
        cmbName.setLayoutX(x);
        cmbName.setLayoutY(y);
        pane.getChildren().add(cmbName);
        return cmbName;
        
    }
}
