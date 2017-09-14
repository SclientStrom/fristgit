import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String []args) throws Exception{
        ClassPathXmlApplicationContext context=new
                ClassPathXmlApplicationContext(new String[]{"/context/context-dubbo.xml"});
        context.start();
        System.in.read();
    }
}
