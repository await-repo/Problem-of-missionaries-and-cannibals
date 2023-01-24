package org.MissionariesAndCannibals;

import org.MissionariesAndCannibals.Graph.Graph;
import org.MissionariesAndCannibals.Graph.State;

public class test {
    public static void main (String []args) {
        //Se crea el Grafo (El grafo inicialmente esta Vacio)
        Graph graph = new Graph();

        //Se crea una instancia con las Reglas y se le manda el Grafo
        Rules rule = new Rules(graph);

        //Añadimos el Estado Inicial
        State initialState = new State( 3,3,0,0,"Left" );
        //Estado prueba = new Estado( 0,1,3,2,"Izq" );
        rule.setInitialState(initialState);

        //Se añade un Estado objetivo (Estado de Meta)
        State targetState = new State( 0,0,3,3,"Right" );
        rule.setTargetState(targetState);

        //Generamos la funcion generarEstructura a partir de las Reglas
        //A partir del estado inicial llegaremos al estado Meta generando todos los Posibles Estados
        rule.generate( graph.getStates() ); //getStates() - retorna la lista de los Estados

        //Se muestran los numeros de Estados y de Aristas

        System.out.println();
        graph.showStates(); //Informacion de los Estados
        System.out.println();
        graph.showEdges(); //Informacion de las Aristas

        System.out.println("\n\nNumber of States : " + graph.numberOfStates());
        System.out.println("Number of Edges : " + graph.numberOfEdges());
    }
}
