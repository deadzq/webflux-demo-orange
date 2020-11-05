package com.example.webfluxdemoorange.s01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.webfluxdemoorange.s01.c03.Bean;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhangQi
 * @Date: 2020-11-03 17:43
 */
public class C03BufferTest {

    public static void main(String[] args) {

        Flux<Integer> currentInteger = Flux.just(1, 2, 3);
        Flux<List<Integer>> listFlux = currentInteger.bufferWhile(i -> i == 2);

        List<Integer> lastInteger = Arrays.asList(1,3);
        Flux<List<Integer>> listFlux1 = currentInteger.bufferWhile(lastInteger::contains);

        JSONArray jsonArray = JSONArray.parseArray(lastInteger.toString());
        System.out.println("jsonArray:"+jsonArray);

        Flux<List<Integer>> listFlux2 = currentInteger.bufferWhile(jsonArray::contains);

        listFlux.subscribe(System.out::println);
        System.out.println("-----------------");
        listFlux1.subscribe(System.out::println);
        System.out.println("-----------------");
        listFlux2.subscribe(System.out::println);
        System.out.println("-----------------");


        Bean btest = new Bean();
        Bean btest2 = new Bean();
        List<Bean> beans = btest.initBeanList();
        List<Bean> beansFull = btest2.initBeanList();
        Flux<Bean> currentBeanFlux = Flux.fromIterable(beansFull);
        System.out.println("list flux:");
        currentBeanFlux.subscribe(System.out::println);
        beans.remove(2);
        beans.remove(3);
        System.out.println("beans removed index 2:"+beans);
        JSONArray beanArrayT = JSONArray.parseArray(JSON.toJSONString(beans));
        System.out.println("beanArrayT:"+beanArrayT);

//        Flux<List<Bean>> listFlux3 = currentBeanFlux.bufferWhile(beanArrayT::contains);
        Flux<List<Bean>> listFlux3 = currentBeanFlux.bufferWhile(beans::contains);
        System.out.println("listBean:");
//        listFlux3.subscribe(o->btest.listBeanStr(o));
        listFlux3.subscribe(o-> System.out.println("oo:"+o));
        System.out.println();
        System.out.println("list flux:");
        currentBeanFlux.subscribe(System.out::println);

        //要获取全部的符合条件的需要进行.filter(Predicate )之后collectToList()即可

        System.out.println("----------------");

        Flux<Integer> integerFlux3 = Flux.just(11, 13, 14, 12, 15);
        Flux<Integer> integerFlux2 = integerFlux3.takeWhile(i -> {
            return i % 2 == 1;
        });
        System.out.println("----------------");
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
