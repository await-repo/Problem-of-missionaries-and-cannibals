package org.MissionariesAndCannibals;

import org.MissionariesAndCannibals.Graph.Graph;
import org.MissionariesAndCannibals.Graph.State;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    //Orilla Izquierda del Rio
    public int MissionaryOnLeft;
    public int CannibalsOnLeft;

    //Orilla Derecha del Rio
    public int MissionaryOnRight;
    public int CannibalsOnRight;

    //Orilla donde esta el Barco
    public String boatSide;


    //Inicio y Fin del Grafo
    public State currentState; //Estado donde empieza el Grafo
    public State targetState; //Estado al que debe llegar

    Graph graph; //Grafo que se debe recibir del constructor

    public Rules(Graph graph) {
        this.graph = graph;
    }

    //Aplica funcion sucesor al estado Actual
    public void applySuccessorFunctionToCurrentState(State state) {
        this.MissionaryOnLeft = state.MissionaryOnLeft;
        this.CannibalsOnLeft = state.CannibalsOnLeft;
        this.MissionaryOnRight = state.MissionaryOnRight;
        this.CannibalsOnRight = state.CannibalsOnRight;
        this.boatSide = state.boatSide;

        this.currentState = state;

        successorFunction();
    }

    public boolean isTheStatusValid() {
        boolean validLeftSide = MissionaryOnLeft < CannibalsOnLeft && MissionaryOnLeft != 0;
        boolean validRightSide = MissionaryOnRight < CannibalsOnRight && MissionaryOnRight != 0;
        return !(validLeftSide || validRightSide) && inRange();
    }

    public boolean inRange() {
        return (MissionaryOnLeft >= 0 && MissionaryOnLeft <= 3) &&
                (CannibalsOnLeft >= 0 && CannibalsOnLeft <= 3) &&
                (MissionaryOnRight >= 0 && MissionaryOnRight <= 3) &&
                (CannibalsOnRight >= 0 && CannibalsOnRight <= 3);
    }

    public void resetToCurrentState() {
        this.MissionaryOnLeft = currentState.MissionaryOnLeft;
        this.CannibalsOnLeft = currentState.CannibalsOnLeft;
        this.MissionaryOnRight = currentState.MissionaryOnRight;
        this.CannibalsOnRight = currentState.CannibalsOnRight;
        this.boatSide = currentState.boatSide;
    }

    public State newStateGenerated() {
        return new State(MissionaryOnLeft, CannibalsOnLeft, MissionaryOnRight, CannibalsOnRight, boatSide);
    }

    //Se inicializa esta clase añadiendo el primer estado valido
    public void setInitialState(State state) {
        this.MissionaryOnLeft = state.MissionaryOnLeft;
        this.CannibalsOnLeft = state.CannibalsOnLeft;
        this.MissionaryOnRight = state.MissionaryOnRight;
        this.CannibalsOnRight = state.CannibalsOnRight;
        this.boatSide = state.boatSide;

        this.currentState = state;
        if ( !graph.existsState(state) )
            graph.addState(state); //Añadimos este estado como pivote si no existe
    }

    //Se pone un estado de meta al cual llegar
    public void setTargetState (State state) {
        this.targetState = state;
    }


    //Inicia a generar el grafo aplicando las reglas dado un Estado Inicial
    public void generate(List<State> states) {
        if (graph.existsState(targetState)) //Caso base, cuando termina definitivamente la Funcion recursiva
            return;

        List<State> copyOfStates = new ArrayList<>(states);
        for (State s : copyOfStates) {
            applySuccessorFunctionToCurrentState(s);
        }
        generate(graph.getStates());
    }


    //Aplicando las Reglas
    public void successorFunction() {
        //Si la regla se cumple entonces se agrega el estado y se enlazan por medio de una arista
        if ( crossOneMissionary() ) {
            graph.addState(newStateGenerated());
            graph.addEdge(currentState, newStateGenerated());
        } if ( crossTwoMissionaries() ) {
            graph.addState(newStateGenerated());
            graph.addEdge(currentState, newStateGenerated());
        } if ( crossOnecannibal() ) {
            graph.addState(newStateGenerated());
            graph.addEdge(currentState, newStateGenerated());
        } if ( crossTwoCannibals() ) {
            graph.addState(newStateGenerated());
            graph.addEdge(currentState, newStateGenerated());
        } if ( crossOneCannibalAndOneMissionary() ) {
            graph.addState(newStateGenerated());
            graph.addEdge(currentState, newStateGenerated());
        }
    }


    //Cruza un Misionero
    public boolean crossOneMissionary(){
        resetToCurrentState();
        if (boatSide.equals("Left")){
            boatSide = "Right";
            MissionaryOnLeft--;
            MissionaryOnRight++;
        }
        else{
            boatSide = "Left";
            MissionaryOnLeft++;
            MissionaryOnRight--;
        }

        return isTheStatusValid();
    }

    public boolean crossTwoMissionaries() {
        resetToCurrentState();

        if (boatSide.equals("Left")){
            boatSide = "Right";
            MissionaryOnLeft -= 2;
            MissionaryOnRight += 2;
        }
        else{
            boatSide = "Left";
            MissionaryOnLeft += 2;
            MissionaryOnRight -= 2;
        }
        return isTheStatusValid();
    }

    public boolean crossOnecannibal () {
        resetToCurrentState();
        if (boatSide.equals("Left")){
            boatSide = "Right";
            CannibalsOnLeft--;
            CannibalsOnRight++;
        }
        else{
            boatSide = "Left";
            CannibalsOnLeft++;
            CannibalsOnRight--;
        }
        return isTheStatusValid();
    }

    public boolean crossTwoCannibals() {
        resetToCurrentState();
        if (boatSide.equals("Left")){
            boatSide = "Right";
            CannibalsOnLeft -= 2;
            CannibalsOnRight += 2;
        }
        else{
            boatSide = "Left";
            CannibalsOnLeft += 2;
            CannibalsOnRight -= 2;
        }
        return isTheStatusValid();
    }

    public boolean crossOneCannibalAndOneMissionary () {
        resetToCurrentState();
        if (boatSide.equals("Left")){
            boatSide = "Right";

            MissionaryOnLeft--;
            CannibalsOnLeft--;
            MissionaryOnRight++;
            CannibalsOnRight++;

        }else{
            boatSide = "Left";

            MissionaryOnLeft++;
            CannibalsOnLeft++;
            MissionaryOnRight--;
            CannibalsOnRight--;
        }
        return isTheStatusValid();
    }



    @Override
    public String toString() {
        return "Rules{" +
                "MissionaryOnLeft=" + MissionaryOnLeft +
                ", CannibalsOnLeft=" + CannibalsOnLeft +
                ", MissionaryOnRight=" + MissionaryOnRight +
                ", CannibalsOnRight=" + CannibalsOnRight +
                ", boatSide='" + boatSide + '\'' +
                '}';
    }

}
