package org.MissionariesAndCannibals.Graph;

public class State {
    public String boatSide;
    public int CannibalsOnLeft;
    public int MissionaryOnLeft;
    public int CannibalsOnRight;
    public int MissionaryOnRight;

    public State (int MissionaryOnLeft, int CannibalsOnLeft, int MissionaryOnRight, int CannibalsOnRight, String boatSide) {
        this.boatSide = boatSide;
        this.CannibalsOnLeft = CannibalsOnLeft;
        this.MissionaryOnLeft = MissionaryOnLeft;
        this.CannibalsOnRight = CannibalsOnRight;
        this.MissionaryOnRight = MissionaryOnRight;
    }

    public boolean isEqual (State state) {
        boolean Equal = this.boatSide.equals(state.boatSide)  &&
                this.CannibalsOnLeft == state.CannibalsOnLeft &&
                this.MissionaryOnLeft == state.MissionaryOnLeft &&
                this.CannibalsOnRight == state.CannibalsOnRight &&
                this.MissionaryOnRight == state.MissionaryOnRight;
        return Equal;
    }

    @Override
    public String toString() {
        return "State {" +
                "boatSide='" + boatSide + '\'' +
                ", CannibalsOnLeft=" + CannibalsOnLeft +
                ", MissionaryOnLeft=" + MissionaryOnLeft +
                ", CannibalsOnRight=" + CannibalsOnRight +
                ", MissionaryOnRight=" + MissionaryOnRight +
                "} ";
    }

}
