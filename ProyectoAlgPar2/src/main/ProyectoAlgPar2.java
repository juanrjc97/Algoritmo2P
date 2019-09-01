/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static controlador.MateriasController.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import modelo.Estudiante;
import modelo.Materia;

/**
 *
 * @author juanjimenez
 */
public class ProyectoAlgPar2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Map<String, List<Estudiante>> mapaMateriasEstudiante = CargarMapa();
        for (Map.Entry<String, List<Estudiante>> entry : mapaMateriasEstudiante.entrySet()) {
            System.out.println("Número de estudiantes: "+entry.getValue().size()+", Código materia: "+entry.getKey()+", Estudiantes: "+entry.getValue().toString());
        }
    }
}