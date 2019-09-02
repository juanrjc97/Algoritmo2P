/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rosy
 */
public class Estudiante {
    String matricula;
    String nombresCompletos;
    String carrera;
    String nivel;
    List<Materia> materiasATomar;

    public Estudiante() {
    }
    
    public Estudiante(String matricula, String nombresCompletos, String carrera, String nivel, List<Materia> materiasATomar) {
        this.matricula = matricula;
        this.nombresCompletos = nombresCompletos;
        this.carrera = carrera;
        this.nivel = nivel;
        this.materiasATomar = materiasATomar;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<Materia> getMateriasATomar() {
        return materiasATomar;
    }

    public void setMateriasATomar(List<Materia> materiasATomar) {
        this.materiasATomar = materiasATomar;
    }

    @Override
    public String toString() {
        return matricula +" -> "+  nombresCompletos + " (" + nivel+")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    } 
}