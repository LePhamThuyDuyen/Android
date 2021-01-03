package com.example.demolaco;

public class Country {
    private String name;
    private  String flag;
    private  int population;

    public Country(String name, String flag, int population) {
        this.name = name;
        this.flag = flag;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return this.name+"(population:"+this.population+")";
    }
}
