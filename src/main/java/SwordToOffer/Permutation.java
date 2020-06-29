package SwordToOffer;

import java.util.*;

public class Permutation {
    Set<String> result = new HashSet<>();
    public String[] permutation(String s) {
        if(s == null) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return result.toArray(new String[result.size()]);
    }

    private void process(String s, String letter, boolean[] visted){
        if(s.length() == letter.length()){
            result.add(letter);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(visted[i]) continue;
            visted[i] = true;
            process(s, letter + String.valueOf(temp), visted);
            visted[i] = false;
        }
    }

    public static void main(String args[]){
        System.out.println(new Permutation().permutation("abc"));
    }
}
