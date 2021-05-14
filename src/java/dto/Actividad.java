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
public class Actividad {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private String FechaInicio;
    private String FechaFin;
    private int Estado;
    private Recurso PersonaEncargada;
    private List<Tarea> Tareas;

    public void setTareas(List<Tarea> Tareas) {
        this.Tareas = Tareas;
    }

    public List<Tarea> getTareas() {
        return Tareas;
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

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public void setPersonaEncargada(Recurso PersonaEncargada) {
        this.PersonaEncargada = PersonaEncargada;
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

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public int getEstado() {
        return Estado;
    }

    public Recurso getPersonaEncargada() {
        return PersonaEncargada;
    }
}
