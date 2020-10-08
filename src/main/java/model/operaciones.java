/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author david
 */
public class operaciones {
    //Variables
    private double base, altura, area, perim;
    private String autor;
    
    //Constructor
    public operaciones(String base, String altura, String autor){
        
        this.setBase(Double.parseDouble(base));
        this.setAltura(Double.parseDouble(altura));
        this.setAutor((autor));
}
    
//Metodos Operaciones
   public void calcArea(){
       double a = (this.getBase() * this.getAltura()) /2;
       this.setArea(a);
   }
   
   public void calcPerim(){
       double b = (this.getBase()*3);
       this.setPerim(b);
   }

//Getters y Setters de Datos
   public double getBase(){
       return base;
   }
 public void setBase(double base){
        this.base = base;
    }
    
    public double getAltura(){
        return altura;
    }
    
     public void setAltura(double altura){
        this.altura = altura;
    }
     
     //Getters y Setters de Resultados
    public double getArea(){
        return area;
    }
    
    public void setArea(double area){
        this.area = area;
    }
    
    public double getPerim(){
        return perim;
    }
    
    public void setPerim(double perim){
        this.perim = perim;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getAutor(){
        return autor;
    }
}