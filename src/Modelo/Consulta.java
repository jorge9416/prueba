/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author manue
 */
public class Consulta extends Conexion{
    
    public boolean registrar(Agente age) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Agente (id_Agente, nombreAgente, rango ) VALUES(?,?,?,)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, age.getId_Agente());
            ps.setString(2, age.getNombreAgente());
            ps.setDouble(3, age.getRango());           
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Agente age) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE Agente SET id_agente=?, nombre_Agente=?, rango=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, age.getId());
            ps.setString(2, age.getnombreAgente());
            ps.setDouble(3, age.getrango());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Agente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Agente WHERE id_Agente=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, age.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Agente age) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM producto WHERE id_Agente=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, age.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               age.setId_Agente(Integer.parseInt(rs.getString("id")));
               age.setNombreAgente(rs.getString("nombre"));
               age.setRango(rs.getString("rango"));             
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
    

