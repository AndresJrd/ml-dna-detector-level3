/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.model;

/**
 *
 * @author AndrésJesús
 */
public enum TipoBusqueda {
    FILAS(0),
    COLUMNAS(1),
    DIAGONALPRI(2),
    DIAGONALSEC(3);
    private Integer estado ;

    TipoBusqueda(Integer estado ){
        this.estado = estado;
    }
    //--------------------------------------------------------------------------
       public String getEstadoString() {
        return estado.toString();
    }
    //--------------------------------------------------------------------------
    public Integer getEstado() {
        return estado;
    }
    //--------------------------------------------------------------------------
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    //--------------------------------------------------------------------------
  @Override
    public String toString() {
        String result="";
        switch(this.getEstado()){
            case 0:
                result = "FILAS";
                break;
            case 1:
                result = "COLUMNAS";
                break;
            case 2:
                 result="DIAGONALPRI";
                 break;
            case 3:
                result="DIAGONALSEC";
                break;
        }
        return result;
    }
    //--------------------------------------------------------------------------
    public  static
            TipoBusqueda getTipoByNumero(int i) {
        return TipoBusqueda.values()[i];
    }

 
}