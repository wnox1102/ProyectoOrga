/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lafrao;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author wilmer07
 */
public class Lafrao extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
        Image Image1=new Image("File:Fondo2.gif");
        ImageView Ver=new ImageView();
        Ver.setImage(Image1);
        Pane f=new Pane();
        f.getChildren().add(Ver);
        Ver.setPreserveRatio(true);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        this.getPersonFilePath();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public File getPersonFilePath() {
    Preferences prefs = Preferences.userNodeForPackage(Lafrao.class);
    String filePath = prefs.get("filePath", null);
    if (filePath != null) {
        return new File(filePath);
    } else {
        return null;
    }
}
    
}
