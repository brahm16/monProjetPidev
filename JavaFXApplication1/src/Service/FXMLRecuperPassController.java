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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLRecuperPassController implements Initializable,IService<User> {
private Connection c;
private Statement st;
private ResultSet rs;
    @FXML
    private TextField txt;
    @FXML
    private Button bot1;
    @FXML
    private Button bott2;
    public static String Nom;
    public static String email;
    public static String pass;
    @FXML
    private Text txt1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         c=DataSource.getInstance().getCon();

    }    

    @FXML
    private void cancel(ActionEvent event) {
    try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLIdentification.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bot1.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }

    @FXML
    private void search(ActionEvent event) throws SQLException {
    String tt=txt.getText().toString();
    if(tt.contains("@"))
    {  
	if(display(tt).next()) {
            try{        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLEnvoyerPass.fxml"));
                           Nom=display(tt).getString("LastName_U");
                           email=display(tt).getString("Email");
                           pass=display(tt).getString("Password");
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bott2.getScene().getWindow(); 
                           stage1.close();
            }
            catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
            }
        else{
            showAlertWithHeaderText("invlid mail address");
        }
    }
    else
    {
        if(tt.length()==8)
        {
        Statement stmt;
    try {
        stmt = c.createStatement();
  	String rq="select * from user where Phone_Number='"+tt+"'";
	ResultSet rst=stmt.executeQuery(rq);
	
        if(rst.next()) {
            try{        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLEnvoyerPass.fxml"));
                           Nom=rst.getString("LastName_U");
                           email=rst.getString("Email");
                             pass=rst.getString("Password");
                           
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bott2.getScene().getWindow(); 
                           stage1.close();
            }
            catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
            }
        else{
            showAlertWithHeaderText("invalid phone number");
        }
    }
        catch (SQLException ex) {
        Logger.getLogger(FXMLIdentificationController.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
        else{
             showAlertWithHeaderText("phone number should has 8 charcter");
        }
    }
}
 private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void retour(MouseEvent event) {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLIdentification.fxml"));
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