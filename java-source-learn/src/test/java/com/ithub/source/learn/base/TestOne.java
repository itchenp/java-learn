package com.ithub.source.learn.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试1
 */
public class TestOne {
    @Test
    public void test01(){
        String str = " ";
        System.out.println(str.length());
        System.out.println(str.isEmpty());
    }

    @Test
    public void test02(){
        String value = "Aesfe2";
        System.out.println(value.charAt(3));
    }

    @Test
    public void test03(){
        System.out.println(2 << 12);
        System.out.println(2 >> 4);
    }

    @Test
    public void test04(){
        int i = 1;
        do{
            i++;
        }while (i<10);

        System.out.println(i);
    }

    @Test
    public void test05(){
//        for (int i = 1; i < 7482;) {
//            // =PHONETIC(C1:D100)
//            System.out.println("=PHONETIC(C"+(i)+":D"+(i+99)+")");
//            i = i +100;
//        }

        for (int i = 1; i < 75; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test06(){
        String name = "${AB}";
        System.out.println(
                name.length()
        );
    }

    @Test
    public void test07(){
        int[] intArr = {1,8,10,89,1000,1234};
        int[] temp = Arrays.copyOf(intArr,8);
        System.out.println(Arrays.toString(temp));
    }


    @Test
    public void test08(){
        List<String> source = new ArrayList<String>(){{
            add("A");add("B");add("C"); add("D");add("E");add("F");add("G");add("H"); add("I");add("J");
        }};
        System.out.println(Arrays.toString(source.toArray()));
        rotate1(source,12);
//        Collections.rotate(source,2);
        System.out.println(Arrays.toString(source.toArray()));
        Collections.rotate(source,-2);
        System.out.println(Arrays.toString(source.toArray()));
    }

    private static <T> void rotate1(List<T> list, int distance) {
        int size = list.size();
        if(size == 0) {
            return;
        }

        distance = distance % size;
        if(distance<0) {
            distance += size;
        }

        if(distance == 0) {
            return;
        }

        for(int cycleStart = 0, nMoved = 0; nMoved != size; cycleStart++) {
            T displaced = list.get(cycleStart);
            int i = cycleStart;
            do {
                i += distance;
                if(i >= size) {
                    i -= size;
                }
                displaced = list.set(i, displaced);
                nMoved++;
            } while(i != cycleStart);
        }
    }

    @Test
    public void test09(){
        int i = 0;
        do{
            i++;
        }while (i!=5);
        System.out.println(i);
    }

    @Test
    public void test10(){
        List<String> source = new ArrayList<String>(){{
            add("A");add("A");add("B");add("B");add("C"); add("C");add("D");add("D");add("E");add("E");
            add("F");add("F");add("G");add("G");add("H"); add("H");add("I");add("I");add("J");add("J");
        }};
        List<String> dest = new ArrayList<String>(){{
            add("a");add("b");add("c");add("d");add("e"); add("f");add("g");add("h");add("i");add("j");
        }};
        Object[] objects = source.toArray();
        Object[] destArr = dest.toArray();
        System.out.println(objects.length);
        System.out.println(Arrays.toString(objects));
        System.arraycopy(destArr,0,objects,3,8);
        System.out.println(objects.length);
        System.out.println(Arrays.toString(objects));
        objects = source.toArray();
        System.arraycopy(objects,0,objects,3,2);
        System.out.println(objects.length);
        System.out.println(Arrays.toString(objects));
    }

}
