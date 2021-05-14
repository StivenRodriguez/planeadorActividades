/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author stivenrodriguez
 */
public class Proyecto {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private String FechaInico;
    private String FechaFin;
    private Recurso PersonaEncarda;
    private List<Actividad> Actividades;

    public void setActividades(List<Actividad> Actividades) {
        this.Actividades = Actividades;
    }

    public List<Actividad> getActividades() {
        return Actividades;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setFechaInico(String FechaInico) {
        this.FechaInico = FechaInico;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public void setPersonaEncarda(Recurso PersonaEncarda) {
        this.PersonaEncarda = PersonaEncarda;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getFechaInico() {
        return FechaInico;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public Recurso getPersonaEncarda() {
        return PersonaEncarda;
    }
}
