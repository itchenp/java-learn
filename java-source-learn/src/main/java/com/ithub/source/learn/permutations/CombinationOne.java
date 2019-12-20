/**
 * Copyright (C), 开店宝支付服务有限公司
 * FileName: CombinationOne
 * Author:   CP.
 * Time:     2019-12-17 10:37
 * Description:
 */
package com.ithub.source.learn.permutations;

import java.util.*;

/**
 *
 * 从排列到组合-分治
 * 穷举毕竟太过暴力，我们来通过分治思想来重新考虑一下这个问题：
 *
 * 分治思想
 * 分治的思想总的来说就是”大事化小，小事化了”，它将复杂的问题往简单划分，直到划分为可直接解决的问题，再从这个直接可以解决的问题向上聚合，最后解决问题。
 *
 * 从 M 个元素中取出 N 个元素整个问题很复杂，用分治思想就可以理解为：
 *
 * 首先，如果我们已经从 M 中元素取出了一个元素，那么集合中还剩下 M-1 个，需要取的元素就剩下 N-1 个。
 * 还不好解决的话，我们假设又从 M-1 中取出了一个元素，集合中还剩下 M-2 个，需要取的元素只剩下 N-2 个。
 * 直到我们可能取了有 M-N+1 次，需要取的元素只剩下一个了，再从剩余集合中取，就是一个简单问题了，很简单，取法有 M-N+1 种。
 * 如果我们解决了这个问题，已经取完最后一次了产生了 M-N+1 种临时集合，再考虑从 M-N+2 个元素中取一个元素呢，又有 M-N+2 种可能。
 * 将这些可能聚合到一块，直到取到了 N 个元素，这个问题也就解决了。
 * 还是从 5 个元素中取 3 个元素的示例：
 *
 * 从 5 个元素中取 3 个元素是一个复杂问题，为了简化它，我们认为已经取出了一个元素，还要再从剩余的 4 个元素中取出 2 个，求解公式为：。
 * 从 4 个元素中取出 2 个依旧不易解决，那我们再假设又取出了一个元素，接下来的问题是如何从 3 个元素中取一个，公式为 。
 * 从 3 个元素中取 1 个已经是个简单问题了，有三种可能，再向上追溯，与四取一、五取一的可能性做乘，从而解决这个问题。
 *
 * @author CP.
 * @create 2019/12/17
 * @since 1.0.0
 */
public class CombinationOne {

    public static void main(String[] args) {
        List<String> m = Arrays.asList("a", "b", "c", "d", "e");
        int n = 5;

        Set<Set<String>> combinationAll = new HashSet<>();
        // 先将问题分解成 五取一、五取二... 等的全排列
        for (int c = 1; c <= n; c++) {
            combinationAll.addAll(combination(m, new ArrayList<>(), c));
        }

        System.out.println(combinationAll);
    }

    /**
     *
     * @param remainEle 原集合
     * @param tempCollection 结果集
     * @param fetchCount 获取数量
     * @return
     */
    private static Set<Set<String>> combination(List<String> remainEle, List<String> tempCollection, int fetchCount) {
        if (fetchCount == 1) {
            Set<Set<String>> eligibleCollections = new HashSet<>();
            // 在只差一个元素的情况下，遍历剩余元素为每个临时集合生成多个满足条件的集合
            for (String ele : remainEle) {
                Set<String> collection = new HashSet<>(tempCollection);
                collection.add(ele);
                eligibleCollections.add(collection);
            }
            return eligibleCollections;
        }

        fetchCount--;
        Set<Set<String>> result = new HashSet<>();
        // 差多个元素时，从剩余元素中取出一个，产生多个临时集合，还需要取 count-- 个元素。
        for (int i = 0; i < remainEle.size(); i++) {
            List<String> collection = new ArrayList<>(tempCollection);
            List<String> tempRemain = new ArrayList<>(remainEle);
            collection.add(tempRemain.remove(i));
            result.addAll(combination(tempRemain, collection, fetchCount));
        }
        return result;
    }
}