package me.dapac.beans;

import me.dapac.interfaces.ITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Player {

    private int dorsal;
    private String name;
    @Autowired
    @Qualifier("madridQualifier")
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

    //@Required
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
