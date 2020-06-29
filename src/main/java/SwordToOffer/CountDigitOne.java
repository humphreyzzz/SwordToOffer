package SwordToOffer;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class CountDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        for(int i=1;i<n;i++){
            char[] chars = String.valueOf(i).toCharArray();
            for(char c:chars){
                if(c=='1') count++;
            }
            ReentrantLock reentrantLock = new ReentrantLock();
        }
        return count;
    }
}
