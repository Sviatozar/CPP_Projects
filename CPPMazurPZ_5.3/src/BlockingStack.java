import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack<T> {
    private final Stack<T> stack;
    private final Lock locker;
    private final Condition isFull;
    private final Condition isEmpty;
    public static final int CAPACITY = 4;

    public BlockingStack() {
        this(new Stack<>());
    }

    public BlockingStack(Stack<T> stack) {
        locker = new ReentrantLock();
        this.stack = stack;
        isFull = locker.newCondition();
        isEmpty = locker.newCondition();
    }

    public void push(T t) {
        try {
            locker.lock();
            while (stack.size() == CAPACITY) {
                isFull.await();
            }
            stack.push(t);
            System.out.println(Thread.currentThread().getName() + " number added, summary "+stack.size()+"\n");
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public T pop() {
        T poppedItem = null;
        try {
            locker.lock();
            while (stack.size() < 1) {
                isEmpty.await();
            }
            poppedItem = stack.pop();
            System.out.println(Thread.currentThread().getName() + " number readed, summary "+stack.size()+"\n");
            isFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        return poppedItem;
    }
}