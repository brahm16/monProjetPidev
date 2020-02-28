/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connexion.DataSource;
import Entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLInscriptionController implements IService<User>,Initializable {
private Connection c;
private PreparedStatement pst;
public static String usr_type;
    ObservableList<String> list=FXCollections.observableArrayList("Admin","AgentFinancier","AgentTransport","Client","AgentGestion");
    /**
     * Initializes the controller class.
     */
    @FXML
     private ChoiceBox Check;
    @FXML
    private Button BottonIn;
    @FXML
    private TextField text1;
    @FXML
    private TextField text3;
    @FXML
    private TextField text4;
    @FXML
    private PasswordField text5;
    @FXML
    private TextField text2;
    @FXML
    private TextField text6;
    @FXML
    private Text txt;
 
     
     
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     Check.setValue("Admin");
     Check.setItems(list);       
      c=DataSource.getInstance().getCon();
    }    


    @FXML
    private void Inscrire(ActionEvent event) throws SQLException {
    String F_name=text1.getText().toString();
    String L_name=text2.getText().toString();
    String mail=text3.getText().toString();
    String ch_Num=text4.getText().toString();
    String type=Check.getValue().toString();
    String photo=text6.getText().toString();
    String pass=text5.getText().toString();
        //
   if(F_name.length()!=0 && L_name.length()!=0 && mail.length()!=0 && ch_Num.length()!=0 && 
           type.length()!=0 && photo.length()!=0 && pass.length()!=0)
   {
        if(pass.length()>=8)
        {
            if(ch_Num.length()==8)
            {
               usr_type=type;
             System.out.println("dfvsdfd"+usr_type);
               int number=Integer.parseInt(text4.getText());
               User u =new User();
               u.setEmail(mail);
               u.setFirstname_u(F_name);
               u.setLastname_u(L_name);
               u.setNumber(number);
               u.setPassword(pass);
               u.setPhoto(photo);
               u.setUsertype(type);
               if(insert(u)==true)
               {
                   try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UNDECORATED);
                       stage.setScene(new Scene(root1));  
                       stage.show();
                       Stage stage1 = (Stage) BottonIn.getScene().getWindow(); 
                       stage1.close();
                       } catch (IOException ex) {
                       Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                      }
            }
            }
            else{
                showAlertWithHeaderText("invalid phone number");
            }
        }
          else{
            showAlertWithHeaderText("the size of password should more then 8 character");
               }
    }
    else
    {
           showAlertWithHeaderText("all fields should be not null");
    }
    }
    
     private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sign In");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void retour(MouseEvent event) {
          try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) txt.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }

    @Override
    public boolean insert(User t) {
String rq = "INSERT INTO user (FirstName_U,LastName_U,Password,UserType,Email,Photo,Phone_Number) VALUES(?,?,?,?,?,?,?)";
			try
                        {      
                        pst = c.prepareStatement(rq);
				pst.setString(1,t.getFirstname_u());
				pst.setString(2,t.getLastname_u());
				pst.setString(3,t.getPassword());
				pst.setString(4,t.getUsertype());
				pst.setString(5,t.getEmail());
				pst.setString(6,t.getPhoto());
				pst.setInt(7,t.getNumber());
				pst.execute();
	                       JOptionPane.showMessageDialog(null,"Succes" ,"message" ,JOptionPane.PLAIN_MESSAGE );
                       return true;
                        }
                        catch (SQLException ex) {
        Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
    }
                        return false;
                        }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet display(String v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
