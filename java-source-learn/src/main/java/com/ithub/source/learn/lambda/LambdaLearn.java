package com.ithub.source.learn.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaLearn {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 循环
//        players.forEach((player) -> System.out.println(player));
//        // 双冒号用法： 类名：：方法名
//        players.forEach(System.out::println);

        // 排序
//        Arrays.sort(atp, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

//        Comparator<String> comparator = ( s1, s2) -> (s1.compareTo(s2));
//        Arrays.sort(atp,comparator);
        Arrays.sort(atp,(s1,s2)->(s1.compareTo(s2)));

        players.forEach(System.out::println);
    }
}
