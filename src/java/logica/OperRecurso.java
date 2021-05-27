/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.Recurso;
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
public class OperRecurso implements Operaciones<Recurso> {

    @Override
    public int insertar(Recurso dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
               String sql = "INSERT INTO Recurso (Nombres, Apellidos, Cargo, Email) VALUES (?,?,?,?)";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getNombres());
                ps.setString(2, dato.getApellidos());
                ps.setString(3, dato.getCargo());
                ps.setString(4, dato.getEmail()); 
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperRecurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public List<Recurso> consultar() {
        String sql = "SELECT * FROM Recurso";

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstRecurso = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Recurso result = new Recurso();
                    result.setId(rs.getInt("id"));
                    result.setNombres(rs.getString("Nombres"));
                    result.setApellidos(rs.getString("Apellidos"));
                    result.setCargo(rs.getString("Cargo"));
                    result.setEmail(rs.getString("Email"));
                    lstRecurso.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperRecurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstRecurso;
    }

    @Override
    public List<Recurso> consultarId(long id) {
        String sql = "SELECT * FROM Recurso WHERE id = " + id + "";
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstRecurso = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Recurso result = new Recurso();
                    result.setId(rs.getInt("id"));
                    result.setNombres(rs.getString("Nombres"));
                    result.setApellidos(rs.getString("Apellidos"));
                    result.setCargo(rs.getString("Cargo"));
                    result.setEmail(rs.getString("Email"));
                    lstRecurso.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperRecurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstRecurso;
    }

    @Override
    public int actualizar(Recurso dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);

                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperRecurso.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OperRecurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

}
