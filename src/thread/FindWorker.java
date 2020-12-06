package thread;

import java.sql.Time;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FindWorker implements Runnable {
    private long min;
    private long max;
    private long data = 0;
    private int sign;

    FindWorker(long min, long max, int sign) {
        this.min = min;
        this.max = max;
        this.sign = sign;

    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    public long getData() {
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);
        long max = 1000000000L;
        int div = 100;
        long range = max / div;

        LinkedList<FindWorker> findWorkers = new LinkedList<>();

        for (int i = 0; i < div + 1; i++) {
            FindWorker t = new FindWorker(i * range, (i + 1) * range, 9);
            findWorkers.addLast(t);
            service.execute(t);
        }
        while (!service.awaitTermination(5, TimeUnit.SECONDS)) {
            TimeUnit.SECONDS.sleep(1);
        }

        // service.wait();
        long ans = 0;
        System.out.println("sum");
        for (FindWorker findWorker : findWorkers) {
            ans += findWorker.getData();
        }

        System.out.println(ans);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("now:");
        for (long i = min; i < max; i++) {
            if (contain(i, sign)) {
                data += i;
            }
        }
        System.out.println("done");
        // return data;
    }
}
