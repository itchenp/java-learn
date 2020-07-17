package com.ithub.source.learn.design.patterns.decorator;

/**
 * 装饰模式
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }
}
