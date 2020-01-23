package me.dapac.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person implements DisposableBean, InitializingBean{

    private int id;
    private String name;
    private String nickname;
    private Country country;
    private City city;

    /*@PostConstruct
    private void init() {
        System.out.println("Before init person bean");
    }
    @PreDestroy
    private void destroy() {
        System.out.println("Person bean to be destroyed");
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", country=" + country +
                ", city=" + city +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Before init person bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Person bean to be destroyed");
    }
}
