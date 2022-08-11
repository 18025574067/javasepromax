package com.itheima.d2_stream;

import java.util.*;
import java.util.stream.Stream;

/**    Stream流式思想的核心：
        是先得到集合或者数组的Stream流（就是一根传送带）
        然后就用这个Stream流操作集合或者数组的元素。
        然后用Stream流简化替代集合操作的API

    集合获取流的API:
        (1) default Stream<E> stream();

    小结：
        集合获取Stream流用：stream();
        数组：Arrays.stream(数组) / Stream.of(数组);
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        /**-----------------Collection集合获取流-------------------*/
        Collection<String> list = new ArrayList<>();
        Stream<String> s = list.stream();


        /**-----------------Map集合获取流-------------------*/
        Map<String, Integer> map = new HashMap<>();

        // 键流
        Stream<String> keyStream = map.keySet().stream();

        // 值流
        Stream<Integer> valueStream = map.values().stream();

        // 键值对流
        Stream<Map.Entry<String, Integer>> keyAndValueStream = map.entrySet().stream();



        /**-----------------数组获取流-------------------*/
        String[] names = {"赵敏", "小昭", "灭绝", "周芷若"};
        Stream<String> name = Arrays.stream(names);
        Stream<String> name2 = Stream.of(names);
    }
}
