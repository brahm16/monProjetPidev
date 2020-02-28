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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class FXMLIdentificationController implements Initializable,IService<User> {
private Connection c;
public static String usr_type;
private Statement st;
private ResultSet rs;
    @FXML
    private TextField txt1;
    @FXML
    private PasswordField txt2;
    @FXML
    private Button bott;
    @FXML
    private Text lab;
    @FXML
    private Text lab1;
    @FXML
    private Text txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 c=DataSource.getInstance().getCon();
    }    

    @FXML
    private void identification(ActionEvent event) throws SQLException {
    String email=txt1.getText().toString();
    String pass=txt2.getText().toString();
        
	if(display(email).next()){
            //String type=rst.getString("UserType");
            ResultSet rs=null;
	    String rqn="select * from user where Password='"+pass+"' AND Email='"+email+"' ";
       	    rs=st.executeQuery(rqn);
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"connexion établie" ,"message" ,JOptionPane.PLAIN_MESSAGE );
               usr_type=rs.getString("UserType");
                    try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UNDECORATED);
                       stage.setScene(new Scene(root1));  
                       stage.show();
                       Stage stage1 = (Stage) bott.getScene().getWindow(); 
                       stage1.close();
                       } catch (IOException ex) {
                       Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                      }
                    
                
            }
            else{
                 showAlertWithHeaderText("invalid password");
            }
    }
        else{
            showAlertWithHeaderText("sir you didn't have an account, you should create it");
        }
} 
    
    @FXML
    private void clicker(MouseEvent event) {
            try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLInscription.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) lab.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }
     private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log In");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void forgot(MouseEvent event) {
          try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLRecuperPass.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) lab1.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
       
try {
        st = c.createStatement();
  	String rq="select * from user where Email='"+v+"'";
        rs=st.executeQuery(rq);
}
 catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    }
return rs;
}
}