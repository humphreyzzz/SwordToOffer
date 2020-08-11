package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/13 21:28
 * @Version 1.0
 **/
public class Singleton {
     private Singleton(){}

     private static class SingletonHolder{
         private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
         return  SingletonHolder.INSTANCE;
    }

}
