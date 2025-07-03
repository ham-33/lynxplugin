package marvtech.lynx.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Small wrapper around a single threaded executor for running tasks.
 */
public final class AsyncHelper {

    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "Lynx-Async");
        t.setDaemon(true);
        return t;
    });

    private AsyncHelper() {
    }

    /**
     * Run the given task asynchronously.
     *
     * @param task runnable to execute
     */
    public static void runAsync(Runnable task) {
        EXECUTOR.submit(task);
    }
}
