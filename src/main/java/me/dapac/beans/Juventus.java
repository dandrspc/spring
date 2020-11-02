package me.dapac.beans;

import me.dapac.interfaces.ITeam;

public class Juventus implements ITeam {
    @Override
    public String display() {
        return "Juventus";
    }
}
