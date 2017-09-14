import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static final int count=200000;
    @Test
    public void poolTest(){
        long startTime=System.currentTimeMillis();
        final List<Integer> integers=new LinkedList<>();
        ThreadPoolExecutor tPool=new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(count));
        final Random random=new Random();
        for(int i=0;i<count;i++){
            tPool.execute(new Runnable() {
                @Override
                public void run() {
                    integers.add(random.nextInt());
                }
            });
        }
        tPool.shutdown();
        try {
            tPool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
        System.out.println(integers.size());
    }

    @Test
    public  void noPoolTest(){
        long startTime=System.currentTimeMillis();
        final List<Integer> integers=new LinkedList<>();
        final Random random=new Random();
        for(int i=0;i<count;i++){
           Thread thread=new Thread(new Runnable() {
               @Override
               public void run() {
                   integers.add(random.nextInt());
               }
           });
           thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
        System.out.println(integers.size());
    }

}
