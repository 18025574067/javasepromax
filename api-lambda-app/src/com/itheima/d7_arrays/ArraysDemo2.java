package com.itheima.d7_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args) {
        // 目标：自定义数组的排序规则，Comparator比较器对象。
        // 1. Arrays 的shot方法对于有值特性的数组是默认升序排序的。
        int[] ages = {12, 33, 2, 11};
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));

        // 2. 需求：降序排序
        // 自定义比较器对象，只能支持引用类型的排序
        Integer[] ages1 = {12, 34, 10, 23};

        Arrays.sort(ages1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                // 指定比较规则
//                if (o1 > o2){
//                    return -1;
//                }else if (o1 < o2){
//                    return 1;
//                }
//                return 0;
                // 可以简化为：
//                return o1 - o2; // 默认升序
                return o2 - o1; // 降序。
            }
        });
        System.out.println(Arrays.toString(ages1));

    }
}
