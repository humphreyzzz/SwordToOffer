import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    public static void main(String[] args){
        String[] a ={"1","2","3"};
        List<String> x = new ArrayList<String>();
        x.add("1");x.add("2");x.add("3");
        Gson gson = new Gson();
        System.out.println(gson.toJson(a));
        System.out.println(gson.toJson(x));
    }
}
