package main;

import main.Exception.TemporadaInvalidaException;
import main.models.Episodio;
import main.models.Serie;
import main.models.Temporada;

import java.util.ArrayList;

public class SerieExercice {
    public static void main(String[] args) {

        // ¡Ejercicio: Sistema de Series!
        // En este ejercicio vas a modelar una serie compuesta por temporadas y episodios.
        // Vas a practicar composición, encapsulamiento, control de lógica y validaciones.

        // CONSIGNA 1:
        // Crear las clases necesarias para representar:
        // - Una Serie
        // - Varias Temporadas
        // - Episodios dentro de cada Temporada

        // CONSIGNA 2:
        // Un Episodio debe tener:
        // - un título
        // - una descripción
        // - un indicador de si fue visto o no
        // - una calificación dada por el usuario
        //   (si no fue visto, debe tener un valor negativo por defecto) POR ESTO USE EL Boolean en el constructor

        // CONSIGNA 3:
        // Una Serie debe tener:
        // - un título
        // - una descripción
        // - un creador
        // - un género
        // - una lista de temporadas, cada una con sus episodios

        // CONSIGNA 4:
        // Implementar un método que permita ingresar una calificación a un episodio.
        // Si la calificación no es válida, mostrar un mensaje y no modificar el valor anterior.

        // CONSIGNA 5:
        // Implementar un método que devuelva el total de episodios vistos en una temporada.

        // CONSIGNA 6:
        // Implementar un método que devuelva el total de episodios vistos en toda la serie.

        // CONSIGNA 7:
        // Implementar un método que calcule el promedio de calificaciones en una temporada.
        // Solo se deben tener en cuenta los episodios que hayan sido vistos.

        // CONSIGNA 8:
        // Implementar un método que calcule el promedio de calificaciones en toda la serie.
        // Solo se deben tener en cuenta los episodios que hayan sido vistos.

        // CONSIGNA 9:
        // Implementar un método que determine si el usuario vio todos los episodios de la serie.

        // CONSIGNA 10:
        // Crear al menos una serie con dos temporadas y varios episodios, probando todas las funcionalidades.
        // Mostrar los resultados por consola.

        // ¡A programar!

        ArrayList<Episodio> episodiosTemp1 = new ArrayList<>();
        //No agrego todos para no hacerlo largo
        Episodio ep1= new Episodio("Good News About Hell","Mark is promoted to lead a team who've had their memories surgically divided between their work and personal lives.",true,3);
        Episodio ep2= new Episodio("Half Loop","The team train new hire Helly on macrodata refinement. Mark takes a day off to meet with a mysterious former colleague.",true,2);
        Episodio ep3= new Episodio("In Perpetuity","Mark takes the team on a field trip, but Helly continues to rebel. A deteriorating Petey struggles to tell Mark about Lumon's misdeeds.",true);
        Episodio ep4= new Episodio("The You You Are","Irving finds an intriguing book at work. Helly aggressively pursues a meeting with her Outie. Mark attends a funeral with Ms. Selvig.",true,4);
        episodiosTemp1.add(ep1);
        episodiosTemp1.add(ep2);
        episodiosTemp1.add(ep3);
        episodiosTemp1.add(ep4);

        Temporada temp1 = new Temporada("Temporada 1","La primera temporada de Severance sigue a Mark, un empleado de Lumon Industries, cuyos recuerdos han sido quirúrgicamente divididos entre su vida laboral y personal.",episodiosTemp1);
        Temporada temp2 = new Temporada("Temporada 2","La segunda temporada de Severance continúa explorando la dinámica de los empleados de Lumon, especialmente Mark Scout (Adam Scott), quien enfrenta las consecuencias de sus acciones en la primera temporada. Mark y su equipo intentan descubrir la verdad sobre Lumon y sus propios orígenes, mientras lidian con las complicaciones que surgen al mezclar sus vidas laborales y personales.");

        Episodio t2epi1= new Episodio("Hello, Ms. Cobel","Mark regresa a la oficina bajo circunstancias distintas. Secretos del mundo de los exus salen a la luz.",false);
        Episodio t2epi2= new Episodio("Goodbye, Mrs. Selvig","Outie Mark contempla el significado de un mensaje. Lumon lidia con las consecuencias de la contingencia de horas extras.",false);

        Serie severance = new Serie("Severance","Mark Scout lidera un equipo en Lumon Industries, cuyos empleados se han sometido a un procedimiento de despido, que implica la división quirúrgica de sus recuerdos entre el trabajo y la vida personal.","Dan Erickson","Ciencia Ficcion");
        severance.agregarTemporada(temp1);
        severance.agregarCalificacion(4,"In Perpetuity");
        severance.agregarCalificacion(7,"The You You Are");
        severance.agregarCalificacion(3,"Hello, Ms. Cobel");

        severance.agregarTemporada(temp2);

        try{
            severance.agregarEpisodioATemporada(2,t2epi1);
            severance.agregarEpisodioATemporada(2,t2epi2);
            System.out.println("Promedio calificacion temporada 1: " + severance.promedioCalificacionTemporada(1));
            System.out.println("Vio el usuario toda la temporada uno? " +  severance.vioTodaLaTemporada(1));
        }catch (TemporadaInvalidaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Promedio calificacion serie: " + severance.promedioCalificaciones());
        System.out.println("Vio el usuario toda la serie? " + severance.vioTodosLosEpisodios());
        System.out.println("Total episodios vistos: " + severance.totalEpisodiosVistos());





    }
}

