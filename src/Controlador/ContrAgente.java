
package Controlador;

import Modelo.Consulta;
import Modelo.Agente;
import Vista.CrudAgente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



/**
 *
 * @author manue
 */
public class ContrAgente implements ActionListener{

    private Agente mod;
    private Consulta modC;
    private CrudAgente frm;

    public ContrAgente(Agente mod, Consulta modC, CrudAgente frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnmodificar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);       
        this.frm.btnbuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Agentes");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmbtnguardar) {
            mod.setId_Agente(frm.txtid.getText());
            mod.setNombreAgente(frm.txtnombre.getText());
            mod.setRango(frm.txtrango.getText());
           
            
            if(modC.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btneliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnbuscar) {
            mod.setId_Agente(frm.txtid.getText());
            
            if(modC.buscar(mod))
            {
                frm.txtid.setText(String.valueOf(mod.getId()));
                frm.txtnombre.setText(mod.getNombreAgente());
                frm.txtrango.setText(mod.getRango());
               

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnlimpiar) {
            limpiar();
        }

    }
    
    public void limpiar()
    {
        frm.txtid.setText(null);
        frm.txtnombre.setText(null);
        frm.txtrango.setText(null);
      
        
    }    

}

   
       
    
