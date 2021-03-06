package com.ithub.source.learn.design.patterns.decorator;

public class Apple extends Food{

    private Food basic_food;

    public Apple() {
    }

    public Apple(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make()+"+苹果";
    }
}
