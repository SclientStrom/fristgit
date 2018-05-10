public class Test {
    public static void main(String[] args) throws Exception {
        //测试，生成10个唯一id
        long startTime=System.currentTimeMillis();
        for (int i = 0; i <=100; i++) {
            Thread.sleep(1000);
            System.out.println(SnowflakeIdGen.nextId());
        }
        System.out.println(System.currentTimeMillis()-startTime+"ms");
    }
}
