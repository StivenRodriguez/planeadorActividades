/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stivenrodriguez
 */
public class OperTarea implements Operaciones<Tarea> {

    @Override
    public int insertar(Tarea dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);
               
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public List<Tarea> consultar() {
        String sql = "";
        
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList  lstTarea = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Tarea result = new Tarea();
                    
                    lstTarea.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstTarea;
    }

    @Override
    public Tarea consultar(long id) {
       String sql = "";
        Tarea result = new Tarea();
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public int actualizar(Tarea dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public int eliminar(int id) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperTarea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
}
