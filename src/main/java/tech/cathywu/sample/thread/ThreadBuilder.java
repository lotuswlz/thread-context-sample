package tech.cathywu.sample.thread;

import java.util.function.Consumer;

public class ThreadBuilder {
    public static void create(int id, long startTime, Consumer<MyOperation> myOperationConsumer) {
        MyOperation myOperation = new MyOperation(id, startTime);
        myOperationConsumer.accept(myOperation);
    }
}
