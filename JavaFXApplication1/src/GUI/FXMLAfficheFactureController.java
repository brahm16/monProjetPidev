/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Facture;
import Entity.FactureTransport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import Service.FactureService;
import Service.FactureTransportService;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author bazinfo
 */
public class FXMLAfficheFactureController implements Initializable {
    @FXML
    private BorderPane BorderPane;
    @FXML
    private Label reference;
    @FXML
    private Label client_name;
    @FXML
    private Label client_type;
    @FXML
    private Label type_facture;
    @FXML
    private Label statut_facture;
    @FXML
    private Label totalHT;
    @FXML
    private Label totalTTC;
    @FXML
    private Label echeance;
    @FXML
    private Label delivery;
    @FXML
    private Label date1;
    @FXML
    private Button qrr;

    Facture f1= new Facture();
    @FXML
    private AnchorPane pane;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
              FactureService   ms =  new FactureService();      
              Facture   E = (Facture) ms.AffichierFacture(2);
              System.out.print(E.toString());
              date1.setText(E.getDateFact());
              reference.setText(E.getReference());
              client_name.setText(E.getClient_name());
              client_type.setText(E.getClient_type());
              type_facture.setText(E.getType_facture()); 
              statut_facture.setText(E.getStatut_facture());
              String a = String.valueOf (E.getTotalHT());
              String b = String.valueOf (E.getTotalTTC());
              String c = String.valueOf (E.getDelivery());
              
              totalHT.setText(a);
              totalTTC.setText(b);
              echeance.setText(E.getEcheance());
             delivery.setText(c);
            
             
             
         
    }    

   
  

    
    
   /* @FXML
   private void retour(MouseEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLFact.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) retour.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLFactController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }*/
   
    private void retour(MouseEvent event) throws IOException {
         Parent page = FXMLLoader.load(getClass().getResource("FXMLFact.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
               stage.setTitle("Liste Achat");
                stage.setScene(scene);
                stage.show();
    }

  


 


    @FXML
    private void qrcode(MouseEvent event) {
         try {
			// Construct data
			String apiKey = "apikey=" + "/F2AyLn99kE-0z2f3UVHnwwTHdTIV57DDNFcO9bcVN";
			String message = "&message=" + "This is your message";
			String sender = "&sender=" + "aymen";
			String numbers = "&numbers=" + "+21650341382";
			
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
		         JOptionPane.showMessageDialog(null, "message"+line);
			}
			rd.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error SMS "+e);
			
		}
    }

    @FXML
    private void maill(MouseEvent event) throws MessagingException, SQLException {
         int aa = 2;
     Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.user", "aymen.hergli@esprit.tn");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        System.out.println("dhdhdhhd");
   
          
         FactureService   ms =  new FactureService();
        
          
             
                String datee = date1.getText();
                String clientname =client_name.getText();
                String etat = statut_facture.getText();
                String factureType = type_facture.getText();
                String mail = ms.maill(clientname);
                
                //System.out.println(deliv);
                Session session = Session.getDefaultInstance(props, null);
                session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                message.setText("facture de client : " + clientname+ " , facture etat: " +etat+ " ,creer le  :"+datee+"");
                message.setSubject("confirmation : ");
                message.setFrom(new InternetAddress("aymen.hergli@esprit.tn"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
                message.saveChanges();
                javax.mail.Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", "aymen.hergli@esprit.tn", "193JMT1301");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Attention");
                alert.setHeaderText(null);
                alert.setContentText("Contrat Envoyer avec succseé ");

                alert.showAndWait();
                   System.out.println("valide ");
    }
}


