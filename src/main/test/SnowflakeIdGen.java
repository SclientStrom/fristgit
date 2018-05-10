public class SnowflakeIdGen {
    //集群id
    private static long datacenterId;
    //机器id
    private static long workerId;
    //序列号
    private static long sequenceId;

    //集群id的bit位数
    private static long datacenterIdBits = 5L;
    //机器id的bit位数
    private static long workerIdBits = 5L;
    //序列号的bit位数
    private static long sequenceIdBits = 12L;

    //集群id的最大编号
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //机器id的最大编号
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    //序列号的掩码
    private static long sequenceIdMask = -1L ^ (-1L << sequenceIdBits);

    //生成最终结果时，集群id需移动的bit位数
    private static long timestampShiftBits = sequenceIdBits + workerIdBits + datacenterIdBits;
    //生成最终结果时，集群id需移动的bit位数
    private static long datacenterIdShiftBits = sequenceIdBits + workerIdBits;
    //生成最终结果时，机器id需移动的bit位数
    private  static long workerIdShiftBits = sequenceIdBits;

    //去掉过去的时间，即从指定时间(本例以2017-10-12 00:00:00)开始算，
    // 大约可用69.5年（41位的时间位，最大值换成毫秒，再换算成年，大约69.5年）
    //1507737600000为从1970-01-01 00:00:00到2017-10-12 00:00:00经过的毫秒数
    private static long pastMills = 1507737600000L;
    //上一次生成id使用的timestamp ，以毫秒为单位
    private static long lastTimestamp = 1L;

    /**
     * 若没有指定集群id和机器id,则默认均为0
     */
    public SnowflakeIdGen() {
        this(0, 0);
    }

    /**
     * 指定集群id和机器id
     *
     * @param datacenterId
     * @param workerId
     */
    public SnowflakeIdGen(long datacenterId, long workerId) {
        if (datacenterId < 0 || datacenterId > maxDatacenterId) {
            throw new RuntimeException(String.format("datacenterId greater than %d or less than 0", maxDatacenterId));
        }
        if (workerId < 0 || workerId > maxWorkerId) {
            throw new RuntimeException(String.format("workerId greater than %d or less than 0", maxWorkerId));
        }
        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    /**
     * 生成全局唯一的id
     *
     * @return
     */
    public static   synchronized  long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {  //出现这种情况，通常是由于机器时间出问题了
            throw new RuntimeException("machine time error");
        }
//        System.out.println("lastTimeStamp:"+lastTimestamp);
        //同一时刻生成的id号
        if (timestamp == lastTimestamp) {
            sequenceId = (sequenceId + 1) & sequenceIdMask;
            if (sequenceId == 0) {  //说明当前毫秒的序列号用完了，需从下个毫秒数开始重新计数
                timestamp = nextTimestamp(lastTimestamp);
            }
        } else {
            //否则序列号从0开始
            sequenceId = 0L;
        }

        lastTimestamp = timestamp;
        long id = ((timestamp - pastMills) << timestampShiftBits)
                | (datacenterId << datacenterIdShiftBits)
                | (workerId << workerIdShiftBits)
                | sequenceId;
        return id;
    }

    /**
     * 获取上次取数毫秒的下一时刻
     *
     * @param lastTimestamp
     * @return
     */
    static long nextTimestamp(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) throws Exception {
        //测试，生成10个唯一id
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            long id = SnowflakeIdGen.nextId();
//            System.out.println(id);
        }
        System.out.println(System.currentTimeMillis()-startTime+"ms");
    }
}