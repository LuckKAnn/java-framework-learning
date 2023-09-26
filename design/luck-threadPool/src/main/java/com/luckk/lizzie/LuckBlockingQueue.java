package com.luckk.lizzie;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author liukun.inspire
 * @Date 2023/9/24 16:59
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckBlockingQueue
 * @Version 1.0
 */
public class LuckBlockingQueue<E> {


    private LinkedList<E> linkedList;

    // 先用sync
    private int size ;

    private int capacity;

    public LuckBlockingQueue() {
        this.size = 0;
        this.capacity = Integer.MAX_VALUE;
        linkedList = new LinkedList<>();
    }

    public LuckBlockingQueue(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
        linkedList = new LinkedList<>();
    }

    public void offer(E e ){
        synchronized (this){
            while (size == capacity){
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            linkedList.addLast(e);
            size++;
            this.notifyAll();
        }
    }

    public E take(){
        synchronized (this){
            while (size ==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            E e = linkedList.removeFirst();
            size--;
            this.notifyAll();
            return e;
        }
    }


    public E take(int time){
        synchronized (this){
            while (size ==0){
                try {
                    this.wait(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            E e = linkedList.removeFirst();
            size--;
            this.notifyAll();
            return e;
        }
    }
}
