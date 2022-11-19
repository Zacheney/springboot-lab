package cn.zach.lab02rabbitmq.producer.service;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * SpringBoot-Labs
 *
 * @author Zach
 * @date 2022/6/14 21:51
 */
public class DelayQueueTest {
    private static DelayQueue<Element> queue = new DelayQueue<>();

    public static void main(String[] args) throws InterruptedException {
        queue.put(new Element("1111", 5000));
        System.out.println(queue.take().getMsg());

    }
}


class Element implements Delayed {
    private String msg;
    private long time;
    private final Long startTime = System.currentTimeMillis();


    public Element(String msg, long time) {
        this.msg = msg;
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(startTime + time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
