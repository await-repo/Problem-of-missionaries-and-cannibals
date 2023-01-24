package org.MissionariesAndCannibals.Graph;

public class Edge {
    State start;
    State end;
    int weight;

    public Edge(State start, State end) {
        this.start = start;
        this.end = end;
        this.weight = 1;
    }

    public boolean isEqual (State start, State end) {
        boolean Equal = this.start.isEqual(start) && this.end.isEqual(end);
        boolean Equal2 = this.start.isEqual(end) && this.end.isEqual(start);
        return Equal || Equal2;
    }

    @Override
    public String toString() {
        return "\nEdge {" +
                "\n\t\t\tstart = " + start +
                "\n\t\t\tend = " + end +
                "\n\t\t} ";
    }
}
