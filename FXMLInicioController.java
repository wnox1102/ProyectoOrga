/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lafrao;

import Logica.Logica;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author wilmer07
 */
public class FXMLInicioController implements Initializable {

    @FXML
    private Button Salir= new Button();
    @FXML
    private Button Catalogo = new Button();
    @FXML
    private Button Cliente = new Button();
    @FXML
    private Button Alquilar= new Button();
    
    FXMLClientesController c=new FXMLClientesController();
    TableView aux= new TableView();
   
        
  
    
    
    @FXML
    private void Salir(ActionEvent e )throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.close();
        
    }
    
    @FXML 
    private void Catalogo(ActionEvent e)throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLCatalogo.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.show();
    }
    
    @FXML 
    private void Cliente(ActionEvent e)throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLClientes.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.show();
      
       
        
        
    }
    
   @FXML 
    private void Alquilar(ActionEvent e)throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLAlquilar.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.show();
    }
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

  
}
