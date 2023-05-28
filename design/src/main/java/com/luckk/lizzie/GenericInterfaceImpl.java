package com.luckk.lizzie;

/**
 * @Author liukun.inspire
 * @Date 2023/5/17 23:45
 * @PackageName: com.luckk.lizzie
 * @ClassName: GenericInterfaceImpl
 * @Version 1.0
 */
public class GenericInterfaceImpl implements GenericInterface<String>{
    public Integer hello(Integer e) {
        System.out.println("hello");
        return null;
    }

    // @Override
    public String doProcess(String e) {
        System.out.println(e);
        return e;
    }

    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.doProcess("hh");
        genericInterface.hello(1);
    }

    /**
     * 和父类有相同的方法，但是没有重写，报错
     * @param e
     * @return
     */
    // public Object doProcess(Object e){
    //     System.out.println(e);
    //     return  null;
    // }
}
