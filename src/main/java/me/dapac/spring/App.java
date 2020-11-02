package me.dapac.spring;

import me.dapac.beans.City;
import me.dapac.beans.Person;
import me.dapac.beans.Player;
import me.dapac.interfaces.ITeam;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
//        XML configuraction
        /**
         * BeanFactory. lazy-init = true by default
         */
        BeanFactory appContext = new ClassPathXmlApplicationContext("beans.xml");

        Player player = (Player) appContext.getBean("player");
        System.out.println(player.getName() +  "-" + player.getTeam().display());

        //ITeam team = (ITeam)appContext.getBean("madrid  ");
        //System.out.println(team.display());

        // Is important to close the context for the destruction of the bean
        ((ConfigurableApplicationContext)appContext).close();
    }
}
