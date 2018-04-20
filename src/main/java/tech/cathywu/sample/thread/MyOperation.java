package tech.cathywu.sample.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyOperation implements Runnable {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");

    private int id;
    private long startTime;

    public MyOperation(int id, long startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    public void process() {
        Integer info = TerminalService.getInstance().getInfo();
        String currentTime = dateFormat.format(new Date());
        System.out.println(String.format(currentTime + ": id=%d, info=%d, size=%d", this.id, info, ThreadContext.totalSize()));
    }

    @Override
    public void run() {
        ThreadContext.setInfo(new Random().nextInt(1000));
        try {
            while (System.currentTimeMillis() < startTime) {
                if (startTime - System.currentTimeMillis() > 1000L) {
                    Thread.sleep(1000L);
                    continue;
                }
                if (startTime - System.currentTimeMillis() <= 1000L) {
                    Thread.sleep(300L);
                    continue;
                }
                if (startTime - System.currentTimeMillis() <= 100L) {
                    Thread.sleep(30L);
                    continue;
                }
                if (startTime - System.currentTimeMillis() <= 30L) {
                    Thread.sleep(1L);
                }
            }
            for (int i = 0; i < 5; i++) {
                this.process();
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
