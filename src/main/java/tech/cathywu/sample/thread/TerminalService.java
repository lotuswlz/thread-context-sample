package tech.cathywu.sample.thread;

public class TerminalService {

    private static TerminalService instance;
    static {
        instance = new TerminalService();
    }

    private TerminalService() {
    }

    public synchronized static TerminalService getInstance() {
        return instance;
    }

    public Integer getInfo() {
        return ThreadContext.getInfo();
    }
}
