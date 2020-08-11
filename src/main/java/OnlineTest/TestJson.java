package OnlineTest;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        String s1 = null;
        list.add("s1");
        list.add("s2");

        for(String s:list){
            if(s.equals("s1")){
                s1 = s;
            }
        }

        System.out.println(s1);
    }
}
