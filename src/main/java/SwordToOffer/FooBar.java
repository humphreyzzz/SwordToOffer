package SwordToOffer;

import java.util.concurrent.Semaphore;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/23 20:35
 * @Version 1.0
 **/
public class FooBar {
    private int n;
    private volatile boolean lock;
    public FooBar(int n) {
        this.n = n;
        this.lock = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!lock){
                Thread.yield();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            lock = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (lock){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            lock = false;
        }
    }
}
