package me.dapac.spring;

import me.dapac.beans.World;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        World world = appContext.getBean(World.class);
        System.out.println(world.getGreeting());
    }
}
