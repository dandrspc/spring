package me.dapac.spring;

import me.dapac.beans.WorldConfig;
import me.dapac.beans.MarsConfig;
import me.dapac.beans.World;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
//        XML configuration
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

//        Annotation configuration
//        ApplicationContext appContext = new AnnotationConfigApplicationContext(WorldConfig.class, MarsConfig.class);

//        Register mode config
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(WorldConfig.class);
        appContext.register(MarsConfig.class);
        appContext.refresh();

        World world = (World) appContext.getBean("world");
        World mars = (World) appContext.getBean("mars");

        System.out.println(world.getGreeting() + "\n" + mars.getGreeting());
    }
}
