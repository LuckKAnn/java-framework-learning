package com.luckk.lizzie.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class FooAtomic {

    private final AtomicInteger firstDone = new AtomicInteger(1);

    private final AtomicInteger secondDone = new AtomicInteger(1);
    public FooAtomic() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (firstDone.get() !=1){
            firstDone.decrementAndGet();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (secondDone.get() !=1){
            secondDone.decrementAndGet();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        firstDone.incrementAndGet();
    }
}
