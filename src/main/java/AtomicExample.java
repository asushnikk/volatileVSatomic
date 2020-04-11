import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final AtomicExample atomicExample = new AtomicExample();
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                atomicExample.a.incrementAndGet();
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                atomicExample.a.incrementAndGet();
            }
        });
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(atomicExample.a);
    }
}
