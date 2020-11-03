package com.example.webfluxdemoorange.s01;

import reactor.core.publisher.Flux;

/**
 * @Author: zhangQi
 * @Date: 2020-11-03 17:43
 */
public class C01TakeTest {

    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3);
        Flux<Integer> integerFlux1 = integerFlux.takeUntil(i -> i == 2);
        // 1 2
        integerFlux1.subscribe(System.out::println);

        System.out.println("-----------------");


        Flux<Integer> integerFlux3 = Flux.just(11, 13, 14, 12);
        Flux<Integer> integerFlux2 = integerFlux3.takeUntil(i -> {
            return i%2 == 0;
        } );
        // 11 13 14
        integerFlux2.subscribe(System.out::println);




    }
}
