package com.ithub.source.learn.design.patterns.factory.method;


/**
 * 工厂方法
 */
public class Test {

    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        Moveable m = factory.create();
        m.run();
    }
}
