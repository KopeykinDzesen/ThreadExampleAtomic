import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int i = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        for (int j = 0; j < 10000; j++) {
            new MyThread().start();
        }

        Thread.sleep(1000);
        System.out.println(i);

        for (int j = 0; j < 10000; j++) {
            new MyThreadAtomic().start();
        }

        Thread.sleep(1000);
        System.out.println(atomicInteger.get());


    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            i++;
        }
    }

    static class MyThreadAtomic extends Thread{
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }

}
