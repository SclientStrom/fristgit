import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static Integer count=0;
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Test
    public void test1(){
        for (int i=0;i<100000000;i++){
            inCreace();
            deCreace();
        }
        System.out.println(count);
    }
    @Test
    public void test2(){
        for (int i=0;i<100000000;i++){
            atomicInteger.incrementAndGet();
            atomicInteger.decrementAndGet();
        }
        System.out.println(atomicInteger.get());
    }

    public Integer inCreace(){
        synchronized (this){
            count+=1;
            return count;
        }
    }
    public Integer deCreace(){
        synchronized (this){
            count-=1;
            return count;
        }
    }


}
