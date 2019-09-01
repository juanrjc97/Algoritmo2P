/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import modelo.Estudiante;
import modelo.Materia;

/**
 *
 * @author Rosy
 */
public class MateriasController {
    public static Map<String, List<Estudiante>> map = new HashMap<>();
    
    public static Map<String, String> MateriasNivel300II(){
        Map<String, String> materias300II = new HashMap<>();
        materias300II.put("ADSG1001", "INTRODUCCIÓN A LA GESTIÓN AMBIENTAL");
        materias300II.put("CCPG1019", "METODOLOGÍA DE LA INVESTIGACIÓN EN COMPUTACIÓN");
        materias300II.put("TLMG1001", "REDES DE DATOS");
        materias300II.put("CCPG1018", "ORGANIZACIÓN DE COMPUTADORES");
        materias300II.put("CCPG1009", "DISEÑO DE SOFTWARE");
        return materias300II;
    }
    
    public static Map<String, String> MateriasNivel400I(){
        Map<String, String> materias400I = new HashMap<>();
        materias400I.put("ADMG2001", "EMPRENDIMIENTO E INNOVACIÓN");
        materias400I.put("CCPG1003", "SEGURIDAD DE LA INFORMACIÓN");
        materias400I.put("SOFG1001", "LENGUAJES DE PROGRAMACIÓN");
        materias400I.put("CCPG1010", "DESARROLLO DE APLICACIONES WEB");
        materias400I.put("CCPG1011", "SISTEMAS DE INFORMACIÓN");
        return materias400I;
    }
    
    public static Map<String, Estudiante> CargarEntradas(String filename) throws IOException{
        Map<String, Estudiante> mapaMaterias = new HashMap<>();
        Map<String, String> mapa400I = MateriasNivel400I();
        Map<String, String> mapa300II = MateriasNivel300II();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"))) {
            String cadena;
            cadena = buffer.readLine(); //saltar la primera línea del archivo
            while ((cadena = buffer.readLine()) != null) {
                String[] line = cadena.split("\\|");
                List<Materia> listaMaterias = new LinkedList<>();
                for (String o : line[4].split(",")){
                    if (mapa400I.get(o) != null) {
                        listaMaterias.add(new Materia(o, mapa400I.get(o)));
                    }
                    if (mapa300II.get(o) != null) {
                        listaMaterias.add(new Materia(o, mapa300II.get(o)));
                    }
                }
                Estudiante e = new Estudiante(line[0], line[1], line[2], line[3], listaMaterias);
                mapaMaterias.put(e.getMatricula(), e);
            }
        }
        return mapaMaterias;
    }
    
    private static void LlenarCodigosMaterias() {
        for(Map.Entry<String, String> entry : MateriasNivel400I().entrySet()) {
            List<Estudiante> est = new LinkedList<>();
            map.put(entry.getKey(), est); 
        }
        for(Map.Entry<String, String> entry : MateriasNivel300II().entrySet()) {
            List<Estudiante> est = new LinkedList<>();
            map.put(entry.getKey(), est); 
        }
    }
    
    public static Map<String, List<Estudiante>> CargarMapa() throws IOException {
        Map<String, Estudiante> mapaC1 = CargarEntradas("src/recursos/datasetConsejero1.txt");
        Map<String, Estudiante> mapaC2 = CargarEntradas("src/recursos/datasetConsejero2.txt");
        LlenarCodigosMaterias();
        for (Map.Entry<String, Estudiante> entry : mapaC1.entrySet()) {
            for (Materia m : entry.getValue().getMateriasATomar()){
                map.get(m.getIdMateria()).add(entry.getValue());
            }         
        }
        for (Map.Entry<String, Estudiante> entry : mapaC2.entrySet()) {
            for (Materia m : entry.getValue().getMateriasATomar()){
                map.get(m.getIdMateria()).add(entry.getValue());
            }         
        }
        return map;
    }    
}