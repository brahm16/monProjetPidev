/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static GUI.Facebook_PostController.Path_File;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Twitter_PostController implements Initializable {

    @FXML
    private AnchorPane anchorid;
    @FXML
    private Button Twitter_Post;
    @FXML
    private TextArea message_Post;
    @FXML
    private Button browse;
    static String status;

    static String name_File;
    static String Path_File;
    private File file;
    private String AccessToken = "1232035847865802752-ScSdDPQsolkWMZkNivLhKDW05v5zkv";
    private String AccessTokenSecret = "dO9mtNhPQKG7bXYQ3XtSMn5w1MdESMHVGDd1pNeiB0i17";
    private String ConsumerSecret = "Q5SH2rKBy8Kdi3WqAX94Jz890YMaN8r6Zt9QoYxbodOY1T8y0e";
    private String ConsumerKey = "YaGj2J9JH0ALYBWyh3XKazhv6";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Post_To_Page(MouseEvent event) throws TwitterException {
        String messsage = message_Post.getText();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthAccessToken(AccessToken);
        cb.setOAuthAccessTokenSecret(AccessTokenSecret);
        cb.setOAuthConsumerSecret(ConsumerSecret);
        cb.setOAuthConsumerKey(ConsumerKey);

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter tweet = tf.getInstance();
        if (status.equals("vide")) {
            try {
                String Only_Message = messsage;
                StatusUpdate status = new StatusUpdate(Only_Message);
                tweet.updateStatus(status);
            } catch (TwitterException ex) {
                Logger.getLogger(Twitter_PostController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            File imagefile1 = new File(Path_File);
            try {
                String statusMessage = messsage;
                StatusUpdate status = new StatusUpdate(statusMessage);

                status.setMedia(imagefile1);
                tweet.updateStatus(status);
            } catch (TwitterException ex) {
                Logger.getLogger(Twitter_PostController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void browse(ActionEvent event) {

        final FileChooser dirchooser = new FileChooser();
        Stage stage = (Stage) anchorid.getScene().getWindow();
        File file = dirchooser.showOpenDialog(stage);
        if (file != null) {
            status = "nonvide";
            System.out.println(status);

            Path_File = file.getAbsolutePath();
            name_File = file.getName();

        } else {
            status = "vide";
            System.out.println(status);
        }
    }
}
