package com.sh.generics._03._extends;

public class AnimalFarm<T extends Animal>{
    private T animal;

    public AnimalFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
