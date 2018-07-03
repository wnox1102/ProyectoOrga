/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lafrao;

import Logica.Cliente;
import Logica.Logica;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import lafrao.FXMLInicioController;
import javafx.collections.FXCollections;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;





/**
 * FXML Controller class
 *
 * @author wilmer07
 */
public class FXMLClientesController implements Initializable {

    @FXML
    TextField Nombre=new TextField();
    @FXML
    TextField Cedula=new TextField();
    @FXML
    Button Agregar=new Button();
    @FXML
    TextField Apellido=new TextField();
   @FXML
    TableView<Cliente> Tabla= new TableView();
    Logica l=new Logica();
    TableColumn<Cliente,String> nombre=new TableColumn("NOMBRE");
    TableColumn<Cliente,String> apellido=new TableColumn("APELLIDO");
    TableColumn <Cliente,Integer>cedula=new TableColumn("CEDULA");
    Scanner s;
     int index=0;
   

    @FXML
    private void Agregar(ActionEvent e) throws IOException{
        
       if(Nombre.getText().isEmpty()==false && Cedula.getText().isEmpty()==false && Apellido.getText().isEmpty()==false){
      
       Cliente cliente = new Cliente();
       cliente.setNombre(Nombre.getText());
       cliente.setApellido(Apellido.getText());
       cliente.setCedula(Integer.parseInt(Cedula.getText()));
//       l.getIndexDatos().add(index, cliente);
       l.getIndexCedula().add(cliente);
       Tabla.getItems().add(cliente);
       Nombre.setText("");
       Apellido.setText("");
       Cedula.setText("");
       index++;
       System.out.println(index);
       
      
        for(int i=0; i<l.getIndexDatos().size(); i++){
            System.out.println(l.getIndexDatos().get(i).getNombre());
            
            
//            System.out.println(l.getIndexCedula().get(i).getNombre());
        }
       
        } 
        Collections.sort(l.getIndexCedula(), Cliente.OrdenCedula);
    }
    
    
    @FXML
    private void Consultar(ActionEvent e){
    
     if(Cedula.getText().isEmpty()==false){
             System.out.println(l.BusquedaClientes(l.getIndexCedula(),Integer.parseInt(Cedula.getText())));
        }
        
     
        
    }
    
    @FXML
    private void Eliminar(ActionEvent e) throws IOException{
        
     if(Tabla.getItems().isEmpty()==false){
     l.getIndexDatos().remove(Tabla.getSelectionModel().getSelectedItem());
     Tabla.getItems().remove(Tabla.getSelectionModel().getSelectedItem());
     Tabla.refresh();
 
     for(int i=0; i<l.getIndexDatos().size(); i++){
         System.out.println(l.getIndexDatos().get(i).getNombre()+" lista nueva");
     }
     }
     
       
    
    }
    
    @FXML
    private void Modificar(ActionEvent e){
        
      if(Nombre.getText().isEmpty()==false){
      Tabla.getSelectionModel().getSelectedItem().setNombre(Nombre.getText());
      }if(Cedula.getText().isEmpty()==false){
          Tabla.getSelectionModel().getSelectedItem().setCedula(Integer.parseInt(Cedula.getText()));
      }if(Apellido.getText().isEmpty()==false){
          Tabla.getSelectionModel().getSelectedItem().setApellido(Apellido.getText());
          
      }
      Tabla.refresh();
      
      for(int i=0; i<l.getIndexDatos().size(); i++){
        System.out.println(l.getIndexDatos().get(i).getNombre());
      }
    }

    
    @FXML
    private void Atras(ActionEvent e) throws IOException{
        Parent Iniciar_parent =FXMLLoader.load(getClass().getResource("FXMLInicio.fxml"));
        Scene Menu=new Scene(Iniciar_parent);
        Stage Start_stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        Start_stage.setScene(Menu);
        Start_stage.show();
        l.ArchivoClientes();
    }
    /**
     * Initializes the controller class.
     */
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                    JOptionPane.showMessageDialog(null,"Solo se aceptan LETRAS");
                 
                     
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
                    JOptionPane.showMessageDialog(null,"Solo se aceptan LETRAS");
                 
                     
                }
                }   
            }
        });
       
       Tabla.getColumns().addAll(nombre,apellido,cedula);
       nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre") );
       apellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
       cedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
    
      }
    
    
}
