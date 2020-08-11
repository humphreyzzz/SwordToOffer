package SwordToOffer;

import sun.awt.geom.AreaOp;

import java.util.HashMap;

public class LRUCache{
    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        Node(int k,int v){
            key = k;
            val = v;
        }
        Node(){}

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(key);
            sb.append(",");
            sb.append(val);
            sb.append(")");
            return sb.toString();
        }
    }
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.pre = null;

        tail.next = null;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node.next!=null){
            node = node.next;
            sb.append(node);
        }
        return sb.toString();
    }

    private void moveToLast(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        addToTail(node);
    }

    private void addToTail(Node node){
        Node pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
    }

    private int removeFirst(){
        Node first = head.next;
        Node next = first.next;
        head.next = next;
        next.pre = head;
        return first.key;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToLast(node);
            return map.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToLast(map.get(key));
        }else{
            if(map.size()==capacity){
                int k =removeFirst();
                map.remove(k);
            }
            Node node = new Node(key,value);
            addToTail(node);
            map.put(key,node);
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        System.out.println(cache);
        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,3);
        System.out.println(cache);
        cache.put(4,1);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
    }
}