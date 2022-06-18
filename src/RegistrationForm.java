
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.util.*;
import java.io.File;

public class RegistrationForm extends Stage {

    private Pane regisPane, regisPane2;
    private Scene regisScene;
    private Label labTitle, labName, labPass, labLoginErr;
    private Label lab2Title, lab2Gender, lab2Nationality;
    private TextField tFieldPassword, tFieldNationality;
    private Button butLogin, butSubmit;
    private ComboBox cmbName, cmbGender;
    private List<User> userLists;
    private AnalysisForm tForm;
    private User currUser;
    private HelperFunctions helperFunc = new HelperFunctions();

    public RegistrationForm() 
    {
        regisPane = new Pane();
        regisPane2 = new Pane();
        regisScene = new Scene(regisPane, 400, 400);
        this.setTitle("Login Form");
        this.setScene(regisScene);

        //First Panel
        labTitle = helperFunc.createLabelParam(regisPane, "Login Page", 30, 20, false);
        labName = helperFunc.createLabelParam(regisPane, "Name", 30, 80, false);
        labPass = helperFunc.createLabelParam(regisPane, "Password", 30, 120, false);
        labLoginErr = helperFunc.createLabelParam(regisPane, "Error! Wrong password", 150, 200, true);
        labLoginErr.setVisible(false);

        tFieldPassword = helperFunc.createTextFieldParam(regisPane, 150, 120, false);
        butLogin = helperFunc.createButtonParam(regisPane, "Login", 300, 300, false);

        cmbName = helperFunc.createComboBox(regisPane, 150, 80);
        this.readApplicants();

        butLogin.setOnAction(e -> 
        {
            this.currUser = this.checkAuth(String.valueOf(cmbName.getValue()), tFieldPassword.getText());
            try 
            {
                if (this.currUser.getType() == 1) 
                {
                    regisScene.setRoot(regisPane2);
                } 
                else if (this.currUser.getType() == 0) 
                {
                    this.close();
                }
            } 
            catch (Exception exc) 
            {
                labLoginErr.setText("Error! Wrong Password");
                labLoginErr.setVisible(true);
            }
        });

        //Second Panel
        lab2Title = helperFunc.createLabelParam(regisPane2, "General Information Page", 30, 20, false);
        lab2Gender = helperFunc.createLabelParam(regisPane2, "Gender", 30, 80, false);
        lab2Nationality = helperFunc.createLabelParam(regisPane2, "Nationality", 30, 120, false);
        tFieldNationality = helperFunc.createTextFieldParam(regisPane2, 150, 120, false);
        cmbGender = helperFunc.createComboBox(regisPane2, 150, 80);
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        butSubmit = helperFunc.createButtonParam(regisPane2, "Start Exam", 300, 300, false);
        butSubmit.setOnAction(e -> 
        {
            this.currUser.setGender(String.valueOf(cmbGender.getValue()));
            this.currUser.setNationality(tFieldNationality.getText());
            this.close();

        });

        this.show();
    }

    private void readApplicants() 
    {
        userLists = new ArrayList<User>();
        Scanner afile;
        String[] lineArray;
        try 
        {
            File file = new File("src/data/applicants.txt");
            afile = new Scanner(file);
            while (afile.hasNextLine()) 
            {
                String line = afile.nextLine();
                lineArray = line.split(":");
                userLists.add(new User(Integer.valueOf(lineArray[0]), lineArray[1], lineArray[2]));
                cmbName.getItems().add(lineArray[1]);
            }
            afile.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("FILE NOT FOUND.");
        }
    }

    private User checkAuth(String name, String password) 
    {
        for (int i = 0; i < this.userLists.size(); i++) 
        {
            if (name.equals(this.userLists.get(i).getName())) 
            {
                if (password.equals(this.userLists.get(i).getPassword())) 
                {
                    if (this.userLists.get(i).getType() == 0) 
                    {
                        return this.userLists.get(i);
                    } 
                    else 
                    {
                        return this.userLists.get(i);
                    }
                } 
                else 
                {
                    return null;
                }
            }

        }
        return null;
    }
    
    public User getCurrUser()
    {
        return this.currUser;
    }
}
