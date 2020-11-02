package me.dapac.beans;

import me.dapac.interfaces.ITeam;

public class Madrid implements ITeam {

    @Override
    public String display() {
        return "Real Madrid";
    }
}
