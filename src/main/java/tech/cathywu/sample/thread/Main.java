package tech.cathywu.sample.thread;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis() + 5000L;
        for (int i = 0; i < 5; i++) {
            ThreadBuilder.create((i + 1), startTime, myOperation -> new Thread(myOperation).start());
        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total size=" + ThreadContext.totalSize());
    }
}
