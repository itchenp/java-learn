package com.ithub.source.learn.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class XiaoMei {
    private List<Person> list = new ArrayList<>();

    public XiaoMei() {
    }

    public void addPerson(Person pserson){
        list.add(pserson);
    }


    public void notifyPerson(){
        for (Person person : list) {
            person.getMessage("过来玩游戏");
        }
    }

}
