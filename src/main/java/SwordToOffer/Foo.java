package SwordToOffer;

import java.util.concurrent.Semaphore;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/23 17:11
 * @Version 1.0
 **/
public class Foo {
    private Semaphore firstDone;
    private Semaphore secondDone;
    public Foo() {
        firstDone = new Semaphore(0);
        secondDone = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.release();


    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
