public class VolatileExample {

    public volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        final VolatileExample volatileExample = new VolatileExample();
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                volatileExample.a++;
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5000; i++) {
                volatileExample.a++;
            }
        });
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(volatileExample.a);
    }
}
