/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedWriter;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.collections.FXCollections;

/**
 *
 * @author wilmer07
 */
public class Logica {
    ArrayList <Cliente>IndexDatos=new ArrayList<Cliente>();
    ArrayList <Cliente>IndexCedula=new ArrayList<Cliente>();
    ArrayList <Pelicula>IndexPelicula=new ArrayList<Pelicula>();
    ArrayList <Pelicula>IndexGenero=new ArrayList<Pelicula>();
    Scanner s;
    
    //Metodo para agregar informacion al archivo de texo clientes
    
    //Metodo para extraer la informacion del archivo de texto
    public  void abrir() throws FileNotFoundException   {
    
        s=new Scanner(new File("C:\\Users\\wilmer07\\Documents\\NetBeansProjects\\Lafrao\\src\\Logica"));
        int Index=0;
        while(s.hasNextLine()){
            
            String line=s.nextLine();
            Cliente client=new Cliente();
            String Name=line.substring(0, 25).trim();
            int ci=parseInt(line.substring(25, 40).trim());
            client.setNombre(Name);
            client.setCedula(ci);
            IndexCedula.add(Index, client);
            Index++;
        
}
}
    public void ArchivoClientes()throws IOException{
        
        String ruta = "C:\\Users\\wilmer07\\Documents\\NetBeansProjects\\Lafrao\\src\\Logica\\Clientes.txt";
        File archivo = new File(ruta);
        FileWriter f=new FileWriter(archivo.getAbsoluteFile(),true);
        s=new Scanner(archivo);
        
        BufferedWriter bw ;
         
        if(archivo.exists()) {
      // El fichero ya existe
            
            System.out.println("El archivo existe");
            bw = new BufferedWriter(f);
            for(int i=0; i<IndexCedula.size(); i++){
            bw.write(IndexCedula.get(i).getNombre());
            bw.newLine();
            }
          Collections.sort(IndexCedula,Cliente.StuRollno);
           bw.close();
        }
        else {
      // El fichero no existe y hay que crearlo
            System.out.println("El archivo no existe hay que crearlo");
        }
        
    }
    public void ArchivoPeliculas()throws IOException{
        
        String ruta = "C:\\Users\\wilmer07\\Documents\\NetBeansProjects\\Lafrao\\src\\Logica\\Peliculas.txt";
        File archivo = new File(ruta);
        FileWriter f=new FileWriter(archivo.getAbsoluteFile(),true);
        s=new Scanner(archivo);
        
        BufferedWriter bw ;
         
        if(archivo.exists()) {
      // El fichero ya existe
            
            System.out.println("El archivo existe");
            bw = new BufferedWriter(f);
            for(int i=0; i<IndexPelicula.size(); i++){
            bw.write(IndexPelicula.get(i).getNombre());
            bw.newLine();
            }
           bw.close();
        }
        else {
      // El fichero no existe y hay que crearlo
            System.out.println("El archivo no existe hay que crearlo");
        }
        
    }

//Metodo de busqueda binaria para clientes
    
    public int BusquedaClientes (ArrayList<Cliente> clientes,int cedula){
        int nInferior=0;
        int nSuperior=clientes.size()-1;
        int mitad;
        //convertir array a vector
        Cliente[] VectorCliente=new Cliente[clientes.size()];
        clientes.toArray(VectorCliente);
         
       while(nInferior<=nSuperior){
           mitad=(nInferior+nSuperior)/2;
           if(cedula==VectorCliente[mitad].getCedula()){
               return mitad+1;
           }
           else if(cedula<VectorCliente[mitad].getCedula()){
               nInferior=mitad+1;
           }
           else if(cedula>VectorCliente[mitad].getCedula()){
               nSuperior=mitad-1;
           }
       }
       return -1;
    }

    public ArrayList<Cliente> getIndexDatos() {
        return IndexDatos;
    }

    public void setIndexDatos(ArrayList<Cliente> IndexDatos) {
        this.IndexDatos = IndexDatos;
    }

    public ArrayList<Cliente> getIndexCedula() {
        return IndexCedula;
    }

    public void setIndexCedula(ArrayList<Cliente> IndexCedula) {
        this.IndexCedula = IndexCedula;
    }

    public ArrayList<Pelicula> getIndexPelicula() {
        return IndexPelicula;
    }

    public void setIndexPelicula(ArrayList<Pelicula> IndexPelicula) {
        this.IndexPelicula = IndexPelicula;
    }

    public ArrayList<Pelicula> getIndexGenero() {
        return IndexGenero;
    }

    public void setIndexGenero(ArrayList<Pelicula> IndexGenero) {
        this.IndexGenero = IndexGenero;
    }
    
    
    
    
    
    
    
    
    
    
    
}
