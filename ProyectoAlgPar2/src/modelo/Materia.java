/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rosy
 */
public class Materia {
    String idMateria;
    String nombre;

    public Materia() {
    }
    
    public Materia(String idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return idMateria ;//+ ": " + nombre;
    }
    
    
}
