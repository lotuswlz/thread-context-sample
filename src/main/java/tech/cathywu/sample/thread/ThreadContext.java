package tech.cathywu.sample.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadContext {

    private static final String FIELD_NAME = "info";
    private static ThreadLocal<Map<String, Integer>> threadLocal = new ThreadLocal<>();

    public static void setInfo(Integer value) {
        threadLocal.set(new ConcurrentHashMap<String, Integer>() {{
            put(FIELD_NAME, value);
        }});
    }

    public static Integer getInfo() {
        Map<String, Integer> values = threadLocal.get();
        if (hasValue(values)) {
            return values.get(FIELD_NAME);
        }
        return null;
    }

    private static boolean hasValue(Map<String, Integer> values) {
        return values != null && !values.isEmpty();
    }

    public static int totalSize() {
        Map<String, Integer> context = threadLocal.get();
        if (hasValue(context)) {
            return context.size();
        }
        return 0;
    }
}
