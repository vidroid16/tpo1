package task2;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
   private ArrayList<LinkedList<String>> table;
   private final int CAPACITY =10000;

    public MyHashTable() {
        table = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++) {
            table.add(new LinkedList<>());
            //table.get(i).add(null);//TODO
        }
    }

    private int getHashCode(String item){
       int hash = 0;
       for (int i = 0; i < item.length(); i++) {
           hash  = ((hash << 5) - hash + item.charAt(i++));
       }
        long lhash = (long)hash + Integer.MAX_VALUE + 1;
       return (int)(lhash%CAPACITY);
   }
   public void add(String item){
        int key = getHashCode(item);
        table.get(key).add(item);
       System.out.println();
   }
   public int delete (String item){
        int key = getHashCode(item);
        Iterator<String> iterator  = table.get(key).iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(item)){
                iterator.remove();
                System.out.println("Deleting Object: Object was successfuly deleted.");
                return 1;
            }
        }
        System.out.println("Deleting Object: Object not found.");
        return -1;
   }
   public LinkedList<String> getValuesByKey(int i){
        return table.get(i);
   }
   public Pair<Integer,String> find (String item){
       int key = getHashCode(item);
       Iterator<String> iterator  = table.get(key).iterator();
       while (iterator.hasNext()){
           if(iterator.next().equals(item)){
               System.out.println("Finding Object: Object was successfuly finded.");
               System.out.println("     Key: "+key);
               System.out.println("     Value: "+ item);

               return new Pair<>(key,item);
           }
       }
       System.out.println("Finding Object: Object not found.");
       return new Pair<Integer,String>(null,null);
   }
   public int size(){
        return CAPACITY;
   }
}
