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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wilmer07
 */
public class FXMLAlquilarController implements Initializable {
    @FXML
    DatePicker Fecha= new DatePicker();
    @FXML
    DatePicker Fecha2=new DatePicker();
    @FXML
    TextField Nombre=new TextField();
    @FXML
    TextField Cedula=new TextField();
    @FXML
    TextField Apellido=new TextField();
    @FXML
      TableView Al=new TableView();
    
    TableColumn<Pelicula,String> Nomb=new TableColumn("NOMBRE PELICULA");
    TableColumn<Pelicula,String> gene=new TableColumn("GENERO");
    Logica l=new Logica();
    FXMLCatalogoController p=new FXMLCatalogoController();
    
    
    @FXML
    private void AlquilarP(ActionEvent e){
        
    }
    
    
   @FXML
private void Atras(ActionEvent e)throws IOException{
         Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
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
        Fecha.setEditable(false);
        Fecha.setValue(LocalDate.now());
        
        Cedula.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<?extends Number>observable,Number oldValue,Number newValue){
           
                if(newValue.intValue()>oldValue.intValue()){
                    char C=Cedula.getText().charAt(oldValue.intValue());
                       
                     if(!(C>='0'&& C<='9')){
                    Cedula.setText(Cedula.getText().substring(0,Cedula.getText().length()-1));
                    JOptionPane.showMessageDialog(null,"Solo se aceptan numeros");
                 
                     
                }
                }   
            }

           
        });
         
       Nombre.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<?extends Number>observable,Number oldValue,Number newValue){
           
                if(newValue.intValue()>oldValue.intValue()){
                    int C=Nombre.getText().charAt(oldValue.intValue());
                       
                     if(!(C>='A'&& C<='Z'|| C>='a'&& C<='z')){
                    Nombre.setText(Nombre.getText().substring(0,Nombre.getText().length()-1));
                    JOptionPane.showMessageDialog(null,"Solo se aceptan lETRAS");
                 
                     
                }
                }   
            }
        });
        Apellido.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<?extends Number>observable,Number oldValue,Number newValue){
           
                if(newValue.intValue()>oldValue.intValue()){
                    int C=Apellido.getText().charAt(oldValue.intValue());
                       
                     if(!(C>='A'&& C<='Z'|| C>='a'&& C<='z')){
                    Apellido.setText(Apellido.getText().substring(0,Apellido.getText().length()-1));
                    JOptionPane.showMessageDialog(null,"Solo se aceptan lETRAS");
                 
                     
                }
                }   
            }
        });
        
       p.Peliculas.getItems();
      Al.getColumns().addAll(p.nombreP,p.genero,p.Descripcion);
         Al.getItems().setAll(p.Peliculas);
       
        
       

    }    
    
}
