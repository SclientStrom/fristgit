import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class FeatureTest implements Callable<List<String>>{
    private List<String> strs=null;

    public FeatureTest(List<String> strs) {
        this.strs = strs;
    }

    @Override
    public List<String> call() throws Exception {

        for (int i=0;i<strs.size();i++) {
            if(strs.get(i).equals("5")){
                strs.set(i,"this is modify");
            }
        }
        return strs;
    }
}
