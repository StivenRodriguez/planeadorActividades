/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author stivenrodriguez
 */
public class Tarea {
    private int Id;
    private String Descripcion;
    private String FechaInicio;
    private String FechaFin;
    private int Estado;

    public void setId(int Id) {
        this.Id = Id;
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

    public int getId() {
        return Id;
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
}
