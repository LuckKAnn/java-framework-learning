package com.luckk.lizzie.oo;

/**
 * @Author liukun.inspire
 * @Date 2023/8/29 20:55
 * @PackageName: com.luckk.lizzie.oo
 * @ClassName: Cat
 * @Version 1.0
 */
public class Cat extends Animal {


    @Override
    public void instanceMethod() {
        System.out.println("cat instan method");
    }





    public static void main(String[] args) {

        Cat.classMethod();
        ;

        Animal cat = new Cat();
        cat.instanceMethod();



    }

}
