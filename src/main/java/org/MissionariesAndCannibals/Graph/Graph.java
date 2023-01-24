package org.MissionariesAndCannibals.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<State> states = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();


    public void addState (State state){
        if ( !existsState(state) ) {
            states.add(state);
        }
    }

    public boolean existsState (State possibleState) {
        for (State state : states)
            if ( state.isEqual(possibleState))
                return true;
        return false;
    }

    public void addEdge (State start, State end) {
        if ( !existsEdge(start, end) )
            edges.add(new Edge(start, end));
    }

    public boolean existsEdge (State start, State end) {
        for (Edge edge : edges) {
            if ( edge.isEqual(start, end))
                return true;
        }
        return false;
    }

    public void removeState (State state) {
        states.removeIf(aux -> aux == state);
        edges.removeIf(edge -> edge.start == state || edge.end == state);

    }

    public void removeEdge (State start, State end) {
        edges.removeIf(edge -> edge.start == start && edge.end == end);

    }

    public boolean isEmpty() {
        return states.isEmpty();
    }


    public int numberOfStates () {
        return states.size();
    }

    public int numberOfEdges () {
        return edges.size();
    }

    public void showStates () {
        states.forEach(System.out::println);
    }

    public void showEdges () {
        edges.forEach(System.out::println);
    }


    public void setStates (List<State> list ) {
        this.states = list;
    }

    public List<State> getStates () {
        return states;
    }


    @Override
    public String toString() {
        return "Graph {\n states = " + states + "\n\n edges = " + edges + "\n} ";
    }

}
