package com.ithub.source.learn.design.patterns.observer;

/**
 * 观察者模式
 */
public class Test {

    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoWang laoWang = new LaoWang();
        LaoLi laoLi = new LaoLi();

        xiaoMei.addPerson(laoLi);
        xiaoMei.addPerson(laoWang);

        xiaoMei.notifyPerson();
    }
}
