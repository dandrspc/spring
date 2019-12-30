package me.dapac.spring;

import me.dapac.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
//        XML configuraction
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) appContext.getBean("person");
        person.setId(1);
        person.setName("Daniel");
        person.setNickname("dandrspc");
        Person person2 = (Person) appContext.getBean("person");

        System.out.println(person);
        System.out.println(person2);
    }
}
