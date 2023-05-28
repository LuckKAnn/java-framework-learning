package com.luckk.lizzie;

import com.luckk.lizzie.dto.Animal;
import com.luckk.lizzie.dto.Cat;
import com.luckk.lizzie.dto.MiniCat;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/5/17 22:31
 * @PackageName: com.luckk.lizzie
 * @ClassName: GenericElement
 * @Version 1.0
 */
public class GenericElement <T>{


    private T value;


    public T getValue() {
        return value;
    }

    public GenericElement(T value) {
        this.value = value;
    }



    public static <T> void changeElement(T... element){

        for (int i = 0; i < element.length; i++) {
            System.out.println(element[i]);
        }
    }


    public static void showList(List<? extends Cat> list){
        // can not add
        // list.add(new Animal());
        // list.add(new Cat());
        // list.add(new MiniCat());


    }

    public static void showListSuper(List<? super Cat> list){
        // can not add
        list.add(new Cat());
        list.add(new MiniCat());
        for (Object o : list) {

        }

    }

    public  void add(Integer e){

    }
    public  void add(String s){

    }

    public static void main(String[] args) {

        // showList(new ArrayList<Integer>());
        // showList(new ArrayList<Long>());
        //
        // GenericElement.changeElement("a","b","C","eEEE");
    }
}
