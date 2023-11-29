import java.util.Random;
import java.util.stream.IntStream;

public class User implements Runnable {
    public static final int QUEUE_CAPACITY = 10;
    private final int number;
    private final PrintServer printServer;

    public User(int number, PrintServer printServer) {
        this.number = number;
        this.printServer = printServer;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, QUEUE_CAPACITY)
                .forEach(x -> {
                            try {
                                this.createDoc();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }

    private void createDoc() throws InterruptedException {
        synchronized (printServer) {
            int sum = printServer.getQueue().stream().mapToInt(Integer::intValue).sum();
            while (sum == 10) {
                System.out.println("User#" + number + " wait");
                printServer.wait();
            }
            int num = new Random().nextInt(2, 6);
            if (sum + num <= 10) {
                printServer.getQueue().add(num);
                System.out.println("User#" + number + " sent " + num + " task");
            }
            printServer.notifyAll();
        }
    }
}