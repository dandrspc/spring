package me.dapac.spring;

import me.dapac.beans.City;
import me.dapac.beans.Person;
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
        Person person = (Person) appContext.getBean("person");
        City city = (City) appContext.getBean("city");

        System.out.println(person.getNickname());
        System.out.println(city.getName());

        // Is important to close the context for the destruction of the bean
        ((ConfigurableApplicationContext)appContext).close();
    }
}
