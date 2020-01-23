package me.dapac.beans;

public class City {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*private void init() {
        System.out.println("Before init city bean");
    }

    private void destroy() {
        System.out.println("City bean to be destroyed");
    }*/

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
