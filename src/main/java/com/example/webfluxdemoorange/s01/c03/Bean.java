package com.example.webfluxdemoorange.s01.c03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangQi
 * @Date: 2020-11-05 22:06
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bean {

    private String name;

    private Integer tall;

    private String color;

    private Long life;

    public List<Bean> initBeanList() {
        List<Bean> blist = new ArrayList<>();
        Bean b1 = new Bean("h", 11, "green", 100L);
        Bean b2 = new Bean("y", 12, "green", 120L);
        Bean b3 = new Bean("p", 13, "green", 130L);
        Bean b4 = new Bean("y", 14, "green", 140L);
        Bean b5 = new Bean("j", 15, "green", 150L);
        blist.add(b1);
        blist.add(b2);
        blist.add(b3);
        blist.add(b4);
        blist.add(b5);
        return blist;
    }

    public void listBeanStr(List<Bean> list) {
        list.forEach(
                bean -> System.out.print(bean + " ")
        );
    }


}
