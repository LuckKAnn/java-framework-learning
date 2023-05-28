package java.lang;

/**
 * @Author liukun.inspire
 * @Date 2023/4/6 00:27
 * @PackageName: java.lang
 * @ClassName: SharedThreadLocal
 * @Version 1.0
 */
public class SharedThreadLocal<T> extends ThreadLocal<T> {

    private Thread sharedThread;

    public SharedThreadLocal() {
    }

    public SharedThreadLocal(Thread sharedThread) {
        this.sharedThread = sharedThread;
    }

    public void setSharedThread(Thread sharedThread) {
        this.sharedThread = sharedThread;
    }

    public Thread getSharedThread() {
        return sharedThread;
    }

    @Override
    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
        // return super.getMap(t);
    }

    @Override
    void createMap(Thread t, T firstValue) {
        t.threadLocals = new ThreadLocalMap(this, firstValue);
    }
}
