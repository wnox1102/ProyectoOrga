/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Comparator;

/**
 *
 * @author wilmer07
 */
public class Cliente {
    String Nombre;
    String Apellido;
    int Cedula;
    int Pago;
    Pelicula pelicula;
    Logica l=new Logica();

  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getPago() {
        return Pago;
    }

    public void setPago(int Pago) {
        this.Pago = Pago;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
      public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public static Comparator<Cliente> OrdenNombre = new Comparator<Cliente>() {

	public int compare(Cliente s1, Cliente s2) {
	   String Cliente1 = s1.getNombre().toUpperCase();
	   String Cliente2 = s2.getNombre().toUpperCase();

	   //ascending order
	   return Cliente1.compareTo(Cliente2);

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};

    /*Comparator for sorting the list by roll no*/
    public static Comparator<Cliente> OrdenCedula = new Comparator<Cliente>() {

	public int compare(Cliente s1, Cliente s2) {

	   int rollno1 = s1.getCedula();
	   int rollno2 = s2.getCedula();

	   /*For ascending order*/
	   return rollno1-rollno2;

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
    
  

    
    
    
    
    
}
