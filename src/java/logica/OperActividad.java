/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
import dto.Actividad;
import dto.Proyecto;
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
public class OperActividad implements Operaciones<Actividad> {

    @Override
    public int insertar(Actividad dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "INSERT INTO Actividad (Nombre, FechaInicio, FechaFin, Estado, IdRecurso, IdProyecto) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getNombre());
                ps.setString(2, dato.getFechaInicio());                
                ps.setString(3, dato.getFechaFin());
                ps.setString(4, "0");
                ps.setInt(5, dato.getPersonaEncargada().getId());
                ps.setInt(6 , dato.getIdProyecto());                
                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public List<Actividad> consultar() {
        String sql = "SELECT * FROM Actividad";
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstActividad = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Actividad result = new Actividad();
                    result.setId(rs.getInt("id"));
                    result.setNombre(rs.getString("Nombre"));
                    result.setFechaInicio(rs.getString("FechaInicio"));
                    result.setFechaFin(rs.getString("FechaFin"));
                    int idPersona = rs.getInt("IdPersona");
                    
                    OperRecurso operacion = new OperRecurso();
                    Recurso recAux = new Recurso();
                    recAux = operacion.consultarId(idPersona).get(0);
                    result.setPersonaEncargada(recAux);
                    lstActividad.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstActividad;
    }

    @Override
    public List<Actividad> consultarId(long id) {
        String sql = "SELECT * FROM Actividad WHERE idProyecto =" + id + "";
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstActividad = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Actividad result = new Actividad();
                    result.setId(rs.getInt("id"));
                    result.setNombre(rs.getString("Nombre"));
                    result.setFechaInicio(rs.getString("FechaInicio"));
                    result.setFechaFin(rs.getString("FechaFin"));
                    result.setIdProyecto(rs.getInt("idProyecto"));
                    int idPersona = rs.getInt("IdRecurso");
                    
                    OperRecurso operacion = new OperRecurso();
                    Recurso recAux = new Recurso();
                    recAux = operacion.consultarId(idPersona).get(0);
                    result.setPersonaEncargada(recAux);
                    lstActividad.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstActividad;
    }

    @Override
    public int actualizar(Actividad dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "";
                PreparedStatement ps = cActiva.prepareStatement(sql);

                int rta = ps.executeUpdate();
                return rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperActividad.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OperActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
}
