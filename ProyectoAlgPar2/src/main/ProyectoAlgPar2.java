/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static controlador.MateriasController.CargarEntradas;
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
        System.out.println("100 en proyecto sino me quedo :(");
        
        Map<String, Estudiante> mapaC1 = CargarEntradas("src/recursos/datasetConsejero1.txt");
        Map<String, Estudiante> mapaC2 = CargarEntradas("src/recursos/datasetConsejero2.txt");

        Map<String, List<Estudiante>> map = new HashMap<>();
        
        for (Map.Entry<String, Estudiante> entry : mapaC1.entrySet()) {
            List<Estudiante> est = new LinkedList<>();
            for(Materia e : entry.getValue().getMateriasATomar()){
                if (!est.contains(entry.getValue())){
                    est.add(entry.getValue());
                }         
                map.put(e.getIdMateria(), est);
            }
        }
         
        for (Map.Entry<String, Estudiante> entry : mapaC2.entrySet()) {
            List<Estudiante> est = new LinkedList<>();
            for(Materia e : entry.getValue().getMateriasATomar()){
                est.add(entry.getValue());
                map.put(e.getIdMateria(), est);
            }
        }
        
        for (Map.Entry<String, List<Estudiante>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue().toString());
        }
    }   
}