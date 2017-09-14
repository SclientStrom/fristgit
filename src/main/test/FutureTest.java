
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

public class FutureTest {
    @Test
    public void test() throws Exception {
        Runnable run= ()-> System.out.println("sss");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is  thread");
            }
        });
        thread.start();
        run.run();
        /*List<String> strings=new ArrayList<>();
        for(int i=0;i<1000;i++){
            strings.add(""+i);
        }
        FeatureTest featureTest=new FeatureTest(strings);
        FutureTask task=new FutureTask(featureTest);
        List<String> test=new ArrayList<>();
        for (int i=0;i<1000;i++) {
            Thread thread=new Thread(task);
            thread.start();
        }
        List<String>sts= (List<String>) task.get();
        test.addAll(sts);
        System.out.println(test.size());*/

    }
}
