import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashTest {
    private HashMap<String,Integer> maps=new HashMap<>();
    private ConcurrentHashMap<String ,Integer> concurrentHashMaps=new ConcurrentHashMap<>();
    public synchronized void addHash(String key){
        Integer value=maps.get(key);
        if(value==null){
            maps.put(key,1);
        }else {
            maps.put(key,value+1);
        }
    }
    public void addCurrentHashMap(String key){
        Integer value = concurrentHashMaps.get(key);
        if(value==null){
            concurrentHashMaps.put(key,1);
        }else {
            concurrentHashMaps.put(key,value+1);
        }
    }
    @Test
    public void test(){
        for (int i=0;i<1000;i++) {
            addHash("i");
        }
        maps.values().forEach(System.out::println);
    }

    @Test
    public void test2() throws InterruptedException {
        for (int i=0;i<10000;i++) {
            Runnable a= new Runnable() {
                @Override
                public void run() {
                    addCurrentHashMap("i");
                }
            }  ;
            a.run();
        }
        concurrentHashMaps.values().forEach(System.out::println);
    }

}
