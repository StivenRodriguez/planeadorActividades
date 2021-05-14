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
public class Recurso {
    private int Id;
    private String Nombres;
    private String Apellidos;
    private String Cargo;
    private String Email;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getCargo() {
        return Cargo;
    }

    public String getEmail() {
        return Email;
    }
    
    
}
