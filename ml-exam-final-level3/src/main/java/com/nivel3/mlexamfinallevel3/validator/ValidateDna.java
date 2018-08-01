/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.validator;


import com.nivel3.mlexamfinallevel3.model.TipoBusqueda;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AndrésJesús
 */

public class ValidateDna extends  Thread {

    private  static String []adn;
    private  static int detections;//contador de ocurrencias
    private  static String matriz[][];
    private  final int orden=6;// solo matrices cuadradas.
    private  final int eursticDetectionsRepetead=4;//cantidad de letras repetidas >3
    private  final int eursticDetections=1;//cantidad de veces que aparecen las tuplas >1
    private  final String regex = "A{"+eursticDetectionsRepetead+",}|T{"+eursticDetectionsRepetead+",}|G{"+eursticDetectionsRepetead+",}|C{"+eursticDetectionsRepetead+",}"; //cantiad minima de secuencias iguales
    private  final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);    
    /////////////////////////////////////////////////////////////////////
    public ValidateDna(String tipo){
    super(tipo);    
    }
   /////////////////////////////////////////////////////////////////////
    public ValidateDna(){
     detections=0;
    }   
    /////////////////////////////////////////////////////////////////////
    private  void setearDatosMatriz(){
     matriz=new String[orden][orden];
     for(int i=0;i<adn.length;i++)          
            for(int j=0;j<adn[i].length();j++){
                matriz[j][i]=Character.toString(adn[i].charAt(j));
              }
    }
    /////////////////////////////////////////////////////////////////////
    /**
     * Este metodo evalua la secuencia de adn recibida como un arreglo de Strings
     * se vale de hilos, que buscan en diferentes direcciones, e informan de la 
     * cantidad de detecciones a un contador "detections".
     * El metodo puede finalizar por 2 razones:
     * 1)_ Todos los hilos llegaron a su estado final, en este caso no se encontro
     * la cantidad minima de detecciones seteada en "eursticDetectionsRepetead"
     * con lo cual el retorno es false.
     * 2)_Se alcanzo la cantidad minima de detenciones retorna true.
     * @param dna recibe en el arreglo de String las secuancias de ADN a procesar
     * @return retorna si dna comple o no con las condiciones de busqueda.
     */
    public Boolean isMutant(String [] dna) {
     adn=dna;     
     boolean esMutante=false;
     boolean finalizo=false;
        try{
            setearDatosMatriz();
            Thread t1=new ValidateDna(TipoBusqueda.FILAS.toString());
            Thread t2=new ValidateDna(TipoBusqueda.COLUMNAS.toString());
            Thread t3=new ValidateDna(TipoBusqueda.DIAGONALPRI.toString());
            Thread t4=new ValidateDna(TipoBusqueda.DIAGONALSEC.toString());
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
           
            t2.join();
            t3.join();
            t4.join();           
                                   
            while((!finalizo)&&(!esMutante)){
            if(getDetections()>eursticDetections){
              esMutante=true;
            }
            else
                 if(((!t1.isAlive())&&(!t2.isAlive())&&(!t3.isAlive())&&(!t4.isAlive()))){
                            finalizo=true;
                 }
            }

       }
        catch(InterruptedException exc){          
            System.out.println(exc.getMessage());
        }
       
        return esMutante;        

        }
/////////////////////////////////////////////////////////////////////
    /**
     * Dependiendo el nombre que tiene asignado el hilo se llama al metodo de 
     * busqueda correspondiente a cada nombre
     */
@Override
public void run(){
   
        switch (this.getName()) {
            case "FILAS":
                buscaFilas();
                break;
            case "COLUMNAS":
                buscaColumnas();
                break;
            case "DIAGONALPRI":
                buscaDiagonalesPrimarias();
                break;
            case "DIAGONALSEC":
                buscaDiagonalesSecundarias();
                break;
            default:
                break;
        }
}
/////////////////////////////////////////////////////////////////////
/**
 * Este metodo es el encardado de realizar las detecciones, llevando la cuenta 
 * de las ocurrencias 
 * @param string String a analizar
 */
  private void chekAdn(String string){
   Matcher matcher = pattern.matcher(string);        
   while( matcher.find())          
           addDetections();                     
    }
/////////////////////////////////////////////////////////////////////
  /**
   * Este metodo convierte el arreglo de String (adn) en un String, la cual
   * pertime una busqueda horizontal o filas y lo manda a evaluar      
   */
private void buscaFilas(){
    chekAdn( Arrays.toString(adn));
}
/////////////////////////////////////////////////////////////////////
/**
 * Este metodo convirte la matriz en un string(evaluable por el metodo chekAdn)
 * y llama al metodo chekAdn para su evaluacion
 */
  private void buscaColumnas(){
        StringBuilder stb=new StringBuilder();
        for (String[] matriz1 : matriz) {
            for (String matriz11 : matriz1) {
                stb.append(matriz11);
            }
            stb.append(",");
        }
        chekAdn(stb.toString());
    }
/////////////////////////////////////////////////////////////////////
  /**
   * Este metodo construye 2 strings uno con los elementos de la diagonal
   * principal superior, y otro string con los elementos de la diagonal inferior
   * y manda a evaluar cada una al metodo cheAdn
   */
   private void buscaDiagonalesPrimarias(){
        StringBuilder stbTriSup=new StringBuilder();
        StringBuilder stbTriInf=new StringBuilder();
        for(int j=orden-1; j>=0; j--){
            for(int k=0; k<orden; k++){
                if((j + k) < orden){
                   stbTriSup.append(matriz[k][j+k]);                        
                     if((j+k)!=k){
                         stbTriInf.append(matriz[j + k][k]);                            
                     }
                }
                 else {
                       break;
                      }
            }
             stbTriSup.append(",");
             stbTriInf.append(",");           
          }
         chekAdn(stbTriSup.toString());
         chekAdn(stbTriInf.toString());
    }
   /////////////////////////////////////////////////////////////////////
 /**
   * Este metodo construye un string con todos los elementos de la diagonal 
   * secundaria y lo envia a evaluar al metodo chekAdn
   */
    private void buscaDiagonalesSecundarias(){
        StringBuilder stb=new StringBuilder();
        int nroDiag=0;
        while(nroDiag<=(orden-1)+(orden-1)){
            for(int i=0;i<orden;i++){
                for(int j=0;j<orden;j++){
                    if(i+j==nroDiag){
                     stb.append((matriz[j][i]));
                    }
                }
            }
            stb.append(";");
         nroDiag++;
        }
        chekAdn(stb.toString());
    }
/////////////////////////////////////////////////////////////////////
    private static synchronized  void addDetections( ) {
             detections++;
    }
/////////////////////////////////////////////////////////////////////
     public static synchronized int getDetections() {
       return detections;
    }
/////////////////////////////////////////////////////////////////////
}
