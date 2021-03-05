package com.ithub.source.learn.base;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * 测试2
 */
public class TestTwo {
    @Test
    public void test01(){

        System.out.println(1&2);

    }

    @Test
    public void test02(){
        int count = 5;

        count--;

        System.out.println(count);
    }

    @Test
    public void test03(){
        List<String> remainEle = Arrays.asList("a", "b", "c", "d", "e");
        List<String> tempRemain = new ArrayList<>(remainEle);
        List<String> collection = new ArrayList<>(new ArrayList<>());
        collection.add(tempRemain.remove(0));
        System.out.println(collection);
    }

    @Test
    public void test04(){
        double pow = Math.pow(2, 5);
        System.out.println(pow);
    }

    @Test
    public void test05(){
        TreeSet<String> set = new TreeSet<>();
        set.add("SETTLE_TYPE");
        set.add("FEE_TYPE");
        set.add("SERVER_CODE");

        set.comparator();
        System.out.println(set);

        String str = StringUtils.join(Arrays.asList(set.toArray()), "_");
        System.out.println(str);

    }

    @Test
    public void test06(){


        if(1==1 && 1==2){
            System.out.println("1");
        }else if(1==1 && 1==3){
            System.out.println(2);
        }
    }

    @Test
    public void test07(){
        int n = 11;
        long[] l = new long[((n - 1) >> 6) + 1];
        System.out.println(Arrays.toString(l));
    }

    @Test
    public void test08(){
        long[] l = {1L};
        System.out.println(l[0]);
        System.out.println(l[0] |= 1L<<4);
    }

    @Test
    public void test09(){
        int length = 63;
        System.out.println(3 | 0x00000010);
        System.out.println((length >> 5) + ((length & 31) > 0 ? 1 : 0));
    }

    @Test
    public void test10(){
        BitSet bitSet = new BitSet(10);
        bitSet.set(3);

    }

    public static void main(String[] args) {
        // 当然对缺失任意位数的都可以找到
        // 假设缺失两个数字5, 9
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 8, 10}, 10);
    }
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

}
