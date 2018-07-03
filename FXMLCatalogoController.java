/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lafrao;

import Logica.Logica;
import Logica.Pelicula;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wilmer07
 */
public class FXMLCatalogoController implements Initializable {
    
    @FXML
    TextArea Descrip=new TextArea();
    @FXML
    TextField NombreP=new TextField();
    @FXML
    TextField Genero=new TextField();
    @FXML
    TableView <Pelicula>Peliculas= new TableView();
    Logica l=new Logica();
    TableColumn<Pelicula,String> nombreP=new TableColumn("NOMBRE PELICULA");
    TableColumn<Pelicula,String> genero=new TableColumn("GENERO");
    TableColumn<Pelicula,String> Descripcion=new TableColumn("DESCRIPCION");
     int index=0;
    
    @FXML
    private void  AgregarP(ActionEvent e){
       
       if(NombreP.getText().isEmpty()==false && Genero.getText().isEmpty()==false && Descrip.getText().isEmpty()==false && Descrip.getText().length()<60){
       Pelicula pelicula=new Pelicula();
       pelicula.setNombre(NombreP.getText());
       pelicula.setGenero(Genero.getText());
       pelicula.setDescripcion(Descrip.getText());
       l.getIndexPelicula().add(index, pelicula);
       Peliculas.getItems().add(pelicula);
       NombreP.setText("");
       Genero.setText("");
       Descrip.setText("");
        index++; 
      
    }  if(Descrip.getText().isEmpty()==false){
        if(Descrip.getText().length()>60){
            JOptionPane.showMessageDialog(null, "Error solo debe contener 60 caracteres la descripcion de la pelicula");
            Descrip.setText("");
        }
    
        
    }
   
           
          
    }
      
       @FXML
      private void EliminarP(ActionEvent e){
     if(Peliculas.getItems().isEmpty()==false){
     l.getIndexPelicula().remove(Peliculas.getSelectionModel().getSelectedItem());
     Peliculas.getItems().remove(Peliculas.getSelectionModel().getSelectedItem());
     Peliculas.refresh();
 
     for(int i=0; i<l.getIndexDatos().size(); i++){
         System.out.println(l.getIndexPelicula().get(i).getNombre()+" lista nueva");
     }
     }
        
    }
      @FXML
      private void ModificarP(ActionEvent e){
             
      if(NombreP.getText().isEmpty()==false){
      Peliculas.getSelectionModel().getSelectedItem().setNombre(NombreP.getText());
      }if(Genero.getText().isEmpty()==false){
          Peliculas.getSelectionModel().getSelectedItem().setGenero(Genero.getText());
      }
      Peliculas.refresh();
      NombreP.setText("");
      Genero.setText("");
      Descrip.setText("");
      
      for(int i=0; i<l.getIndexDatos().size(); i++){
        System.out.println(l.getIndexPelicula().get(i).getNombre());
      }
      }
      
      @FXML
      private void Buscar(ActionEvent e){
          
      }
    
    
    
    
  
     
  
    
    @FXML
    private void Atras(ActionEvent e) throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.show();
        System.out.println(Descrip.getText().length());
        l.ArchivoPeliculas();
    }
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Peliculas.getColumns().addAll(nombreP,genero,Descripcion);
       nombreP.setCellValueFactory(new PropertyValueFactory<>("Nombre") );
       genero.setCellValueFactory(new PropertyValueFactory<>("Genero"));
       Descripcion.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
      
    }    
    
}
