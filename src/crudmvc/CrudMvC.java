/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.ContrAgente;
import Modelo.Consulta;
import Modelo.Agente;
import Vista.CrudAgente;
/**
 *
 * @author manue
 */
public class CrudMvC {
    
     public static void main(String[] args) {
      
        Agente mod = new Agente();
        Consulta modC = new Consulta();
        CrudAgente frm = new CrudAgente();
        
        ContrAgente ctrl = new ContrAgente(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
