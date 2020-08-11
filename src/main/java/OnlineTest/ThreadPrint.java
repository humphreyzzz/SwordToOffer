package OnlineTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/29 22:03
 * @Version 1.0
 **/
public class ThreadPrint implements Runnable {

    int type;
    Object object;

    ThreadPrint(int type,Object object){
        this.type = type;
        this.object = object;
    }

    @Override
    public void run() {
        while (true){
            synchronized (object){
                try{
                    //打印偶数
                    if(type==0){
                        for(int i=0;i<10;i+=2){
                            System.out.println(i);
                            object.notifyAll();
                            object.wait();
                        }
                    }
                    //打印奇数
                    else{
                        for(int i=1;i<10;i+=2){
                            System.out.println(i);
                            object.notifyAll();
                            object.wait();
                        }
                    }
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }


        }

    }

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Object obj = new Object();
        threadPool.execute(new ThreadPrint(0,obj));
        threadPool.execute(new ThreadPrint(1,obj));
    }
}
