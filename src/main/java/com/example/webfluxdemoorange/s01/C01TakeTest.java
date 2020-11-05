package com.example.webfluxdemoorange.s01;

import reactor.core.publisher.Flux;

/**
 * @Author: zhangQi
 * @Date: 2020-11-03 17:43
 */
public class C01TakeTest {

    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3);
        Flux<Integer> integerFlux1 = integerFlux.takeWhile(i -> i == 2);
        // 不输出
        integerFlux1.subscribe(System.out::println);

        System.out.println("-----------------");


        Flux<Integer> integerFlux3 = Flux.just(11, 13, 14, 12, 15);
        Flux<Integer> integerFlux2 = integerFlux3.takeWhile(i -> {
            return i % 2 == 1;
        });
        // 11 13
        integerFlux2.subscribe(System.out::println);

        System.out.println("----------------");
        System.out.println("take");
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        System.out.println("takeLast");
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        System.out.println("takeWhile");
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        System.out.println("takeUntil");
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

    }
}
