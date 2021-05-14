/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.Proyecto;
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
public class OperProyecto implements Operaciones<Proyecto> {

    @Override
    public int insertar(Proyecto dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);

                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public List<Proyecto> consultar() {
        String sql = "";

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstProyecto = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Proyecto result = new Proyecto();

                    lstProyecto.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstProyecto;
    }

    @Override
    public Proyecto consultar(long id) {
        String sql = "";
        Proyecto result = new Proyecto();
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {

                }
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public int actualizar(Proyecto dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);

                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "DELETE FROM Proyecto WHERE Id = " + id + "";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
}
