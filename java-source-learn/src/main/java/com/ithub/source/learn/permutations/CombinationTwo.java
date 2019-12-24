/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: CombinationTwo
 * Author:   CP.
 * Time:     2019-12-17 11:20
 * Description:
 */
package com.ithub.source.learn.permutations;

import java.util.*;

/**
 *
 * 直击本质-位运算
 *
 * 从元素的全排列找全组合，比穷举略好，但还不是最好的方法，毕竟它”绕了一次道”。
 *
 * 很多算法都能通过位运算巧秒地解决，其优势主要有两点：一者位运算在计算机中执行效率超高，再者由于位运算语义简单，算法大多直指本质。
 *
 * 组合算法也能通过位运算实现。
 *
 * 思想
 * 再次考虑全组合的需求，从 M 个元素中取任意个元素形成组合，组合内元素不能重复、元素位置无关。
 *
 * 之前的方法都是从结果组合是否满足要求来考虑问题，考虑组合是否有重复元素、是否已有同样的组合等条件。如果换种思路，从待选元素上来考虑呢？
 *
 * 对于每个元素来说，它的状态就简单得多了，要么被放进组合，要么不放进组合。每个元素都有这么两种状态。如果从 5 个元素中任意取 N 个元素形成组合的话，用二进制位来表示每个元素是否被放到组合里，就是：
 *
 * A  B  C  D  E
 * 0  0  0  0  1   [E] = 1
 *
 * A  B  C  D  E
 * 0  0  0  1  0   [D] = 2
 *
 * A  B  C  D  E
 * 0  0  0  1  1   [DE] = 3
 * ...
 * 看到这里，应该就非常清楚了吧，每种组合都可以拆解为 N 个二进制位的表达形式，而每个二进制组合同时代表着一个十进制数字，所以每个十进制数字都就能代表着一种组合。
 *
 * 十进制数字的数目我们很简单就能算出来，从00000... 到 11111... 一共有 种，排除掉全都不被放进组合这种可能，结果有 种。
 *
 * @author CP.
 * @create 2019/12/17
 * @since 1.0.0
 */
public class CombinationTwo {

    public static void main(String[] args) {
//        String[] m = {"T1","10001","QUICKPASS_DEBIT"};
//        Set<Set<String>> combinationAll = combination(m);
//        System.out.println(combinationAll);
//
//        for (Set<String> inerSet : combinationAll) {
//            System.out.println(inerSet.iterator().next());
//        }

        List<String> list = new ArrayList();
        list.add("T1");
        list.add("QUICKPASS_DEBIT");
        list.add("10001");
        Set<Set<String>> combination = combination(list.toArray(new String[list.size()]));
        System.out.println(combination);

    }

    private static Set<Set<String>> combination(String[] m) {
        Set<Set<String>> result = new HashSet<>();

        if(m.length==1){
            result.add(new TreeSet<String>(){{add(m[0]);}});
            return result;
        }

        for (int i = 1; i < Math.pow(2, m.length) - 1; i++) {
            Set<String> eligibleCollections = new HashSet<>();
            // 依次将数字 i 与 2^n 按位与，判断第 n 位是否为 1
            for (int j = 0; j < m.length; j++) {
                if ((i & (int) Math.pow(2, j)) == Math.pow(2, j)) {
                    eligibleCollections.add(m[j]);
                }
            }

            result.add(eligibleCollections);
        }
        return result;
    }

}