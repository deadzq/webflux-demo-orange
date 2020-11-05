package com.example.webfluxdemoorange.s01;

import reactor.core.publisher.Flux;

/**
 * @Author: zhangQi
 * @Date: 2020-11-04 11:50
 */
public class C02ReduceTest {

    public static void main(String[] args) {
        //将两两相加 得出结果 5050
        Flux.range(1,100).reduce((x,y)->x+y).subscribe(System.out::println);
        //设置初始值with 100 结果为  5050+100 = 5150
        Flux.range(1,100).reduceWith(()->100,(x,y)->x+y).subscribe(System.out::println);
    }
}
