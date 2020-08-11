package SwordToOffer;

/**
 * @Decription TODO
 * @Author Humphrey
 * @Date 2020/7/21 16:06
 * @Version 1.0
 **/
public class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck instance;
    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance() {

        if(instance==null){
            synchronized (SingletonDoubleCheck.class){
                if(instance==null){
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
