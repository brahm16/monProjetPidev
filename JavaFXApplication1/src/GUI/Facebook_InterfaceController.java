/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Facebook_InterfaceController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label nbrefollowing;
    @FXML
    private Label createdAt;
    @FXML
    private Label screenName;
    @FXML
    private Label email;
    @FXML
    private Label nbrFollowers;
    @FXML
    private Button post;
    @FXML
    private Circle img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String AccessToken = "EAADKms3xDm0BAIpQuDkbL9bQyVMWTQfudgQjZC9BIt6NtutzZBg9q993xJAQtEIuA2EF2BevFRLbeVW0EuC0rit3wKLDsvrBZAfagDeZCKf4B7YmpzrS9JYdNeoFUh9H2gwYcATgeC4LZBBaEMLuY3TJ0Nq4sRWnTLJGiFuvURVFC0iXTmXBgTkDENKejg1YZAOwSbTP5kCppNF7ZCAMKVGJpHF1HNv8QYZD";
        FacebookClient fc = new DefaultFacebookClient(AccessToken, Version.UNVERSIONED);
        User me = fc.fetchObject("me", User.class);
        System.out.println(me.getName());
        System.out.println(me.getLanguages().get(0).getName());

        Connection<Post> result = fc.fetchConnection("me/likes", Post.class);
        int counter = 0;
        for (List<Post> pages : result) {
            for (Post apost : pages) {
                System.out.println(apost.getMessage());
                System.out.println("fb.com/" + apost.getId());
                counter++;
            }

        }
        System.out.println(counter);

    }

    @FXML
    private void Facebook_Post(MouseEvent event) {
    }

}
