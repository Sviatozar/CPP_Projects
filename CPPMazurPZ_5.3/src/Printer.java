import java.util.stream.IntStream;

public class Printer implements Runnable {
    private final int number;
    private final PrintServer printServer;

    public Printer(int number, PrintServer printServer) {
        this.number = number;
        this.printServer = printServer;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10)
                .forEach(x -> {
                            try {
                                this.doTask();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                );
    }

    private void doTask() throws InterruptedException {
        synchronized (printServer) {
            while (printServer.getQueue().isEmpty()) {
                System.out.println("Printer#" + number + " wait");
                printServer.wait();
            }
            int num = printServer.getQueue().poll();
            System.out.println("Printer#" + number + " printed " + num + " task");
            printServer.notifyAll();
        }
    }
}