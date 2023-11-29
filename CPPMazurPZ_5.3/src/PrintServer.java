import java.util.Queue;
import java.util.PriorityQueue;

public class PrintServer {
    private final Queue<Integer> queue;

    public PrintServer() {
        this(new PriorityQueue<>());
    }

    public PrintServer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }
}
