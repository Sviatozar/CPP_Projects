import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task1
        PrintServer printServer = new PrintServer();
        Thread printer1Thread = new Thread(new Printer(1,printServer));
        Thread printer2Thread = new Thread(new Printer(2,printServer));
        Thread user1Thread = new Thread(new User(1,printServer));
        Thread user2Thread = new Thread(new User(2, printServer));
        Thread user3Thread = new Thread(new User(3,printServer));
        Thread user4Thread = new Thread(new User(4,printServer));
        printer1Thread.start();
        printer2Thread.start();
        user1Thread.start();
        user2Thread.start();
        user3Thread.start();
        user4Thread.start();
        */
        /*
        Task2
        BlockingStack<Integer> blockingStack = new BlockingStack<>();
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                blockingStack.push(new Random().nextInt(0, 10));
            }
        });
        Thread consumerThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                blockingStack.pop();
            }
        });
        Thread consumerThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                blockingStack.pop();
            }
        });
        Stream.of(producerThread, consumerThread1, consumerThread2).forEach(Thread::start);
        */
        /*
        Task3
        Thread thread1 = Thread.currentThread();
        Thread thread2 = new Thread(() -> {
            try {
                waiting();
                Thread.sleep(2000);
                thread1.join();
                System.out.println(Thread.currentThread().getState());
                Thread.sleep(2000);
                System.out.println(thread1.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                waiting();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(thread2.getState());
        thread2.start();
        thread3.start();
        Thread.sleep(4000);
        System.out.println(thread3.getState());
        Thread.sleep(4000);
        System.out.println(thread2.getState());
        Thread.sleep(4000);
        System.out.println(thread2.getState());
        */
    }

    private static synchronized void waiting() throws InterruptedException {
        Thread.sleep(7000);
    }
}