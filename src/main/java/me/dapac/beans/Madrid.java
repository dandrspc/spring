package me.dapac.beans;

import me.dapac.interfaces.ITeam;
import org.springframework.stereotype.Component;

@Component
public class Madrid implements ITeam {

    @Override
    public String display() {
        return "Real Madrid";
    }
}
