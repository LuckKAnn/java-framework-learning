package com.luckk.lizzie.thread;

import java.util.concurrent.Semaphore;

public class Foo {

    private final Semaphore first;
    private final Semaphore second;
    private final Semaphore third;

    public Foo() {
        first = new Semaphore(1);
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        first.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        second.acquire();
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        third.acquire();
        printThird.run();
        first.release();
    }

}
