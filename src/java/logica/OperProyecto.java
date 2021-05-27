/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import database.Conexiones;
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
public class OperProyecto implements Operaciones<Proyecto> {

    @Override
    public int insertar(Proyecto dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "INSERT INTO Proyecto (Nombre, Descripcion, FechaInicio, FechaFin, IdPersona) VALUES (?,?,?,?,?)";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getNombre());
                ps.setString(2, dato.getDescripcion());
                ps.setString(3, dato.getFechaInico());
                ps.setString(4, dato.getFechaFin());
                ps.setInt(5, dato.getPersonaEncarda().getId());
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
        String sql = "SELECT * FROM Proyecto";

        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ArrayList lstProyecto = new ArrayList();
        if (cActiva != null) {
            try {
                Statement stmt = cActiva.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Proyecto result = new Proyecto();
                    result.setId(rs.getInt("id"));
                    result.setNombre(rs.getString("Nombre"));
                    result.setDescripcion(rs.getString("Descripcion"));
                    result.setFechaFin(rs.getString("FechaFin"));
                    result.setFechaInico(rs.getString("FechaInicio"));
                    int idPersona = rs.getInt("IdPersona");
                    OperRecurso operacion = new OperRecurso();
                    Recurso recAux = new Recurso();
                    recAux = operacion.consultarId(idPersona).get(0);
                    result.setPersonaEncarda(recAux);
                    lstProyecto.add(result);
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstProyecto;
    }

    @Override
    public List<Proyecto> consultarId(long id) {
        String sql = "SELECT * FROM Proyecto";
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
