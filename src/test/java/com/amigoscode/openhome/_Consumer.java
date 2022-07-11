package com.amigoscode.openhome;

import java.util.Arrays;

/*
如果需要的行為是接受一個引數，然後處理後不傳回值，就可以使用Consumer介面
接受Consumer的實際例子就是Iterable上的forEach方法：
既然接受了引數但沒有傳回值，這行為就像純綷消耗了引數，也就是命名為Consumer的原因
 */
public class _Consumer {
    public static void main(String[] args) {
        Arrays.asList("a","b","c").forEach(System.out::println);
    }
}
