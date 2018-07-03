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
public class Pelicula {
   private String Nombre;
   private String Genero;
   private boolean disponible=true;
   private String Descripcion;
   private int cantidad=2;
   
   
   

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static Comparator<Pelicula> StuNameComparator = new Comparator<Pelicula>() {

	public int compare(Pelicula s1, Pelicula s2) {
	   String Pelicula1 = s1.getNombre().toUpperCase();
	   String Pelicula2 = s2.getNombre().toUpperCase();

	   //ascending order
	   return Pelicula1.compareTo(Pelicula2);

	   //descending order
	   //return StudentName2.compareTo(StudentName1);
    }};



    
   
   
   
   
    
    
}
