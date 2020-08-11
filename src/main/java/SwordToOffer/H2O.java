package SwordToOffer;


import java.util.concurrent.Semaphore;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/23 20:49
 * @Version 1.0
 **/
public class H2O {
    private Semaphore hSema = new Semaphore(2);
    private Semaphore oSema = new Semaphore(2);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        oSema.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        hSema.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oSema.release(2);
    }
}
