/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Agente {
    
    private int id_Agente;
    private String nombreAgente;
    private String rango;
    

    public int getId() {
        return id_Agente;
    }

    public int getId_Agente() {
        return id_Agente;
    }

    public void setId_Agente(int id_Agente) {
        this.id_Agente = id_Agente;
    }

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
    
}
