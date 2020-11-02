package me.dapac.beans;

import me.dapac.interfaces.ITeam;

public class Player {

    private int dorsal;
    private String name;
    private ITeam team;

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }
}
