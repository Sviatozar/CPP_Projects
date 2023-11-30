package Task_2;

public class Task_2 {
    private static final MyLinkedList<Integer> list = new MyLinkedList<Integer>();

    public static void main(String[] args) {
        list.add(1);
        list.add(10);
        list.add(100);
        list.add(1000);
        System.out.println("LinkedList");
        System.out.println("List\n" + list);
        System.out.println("Method Add");
        list.add(1, 2);
        System.out.println(list);
        list.addLast(3);
        list.addFirst(4);
        System.out.println(list);
        System.out.println("Method Remove");
        list.remove(3);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println("Other methods:");
        System.out.println(".size" + list.size());
        System.out.println(".indexOf" + list.indexOf(1));
        System.out.println(".getFirst" + list.getFirst());
        System.out.println(".getLast" + list.getLast());
        list.set(2, 3);
        System.out.println(list);
        /*System.out.println("Queue");
        MyQueue<Integer> queue = new MyQueue<Integer>(list);
        System.out.println("Queue\n" + queue);
        System.out.println("Method offer");
        queue.offer(2);
        System.out.println(queue);
        System.out.println("Method peek");
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println("Method pool");
        System.out.println(queue.poll());
        System.out.println(queue);*/
        /*System.out.println("Stack");
        MyStack<Integer> stack = new MyStack<Integer>(list);
        System.out.println("Stack\n" + stack);
        System.out.println("Method push");
        stack.push(2);
        System.out.println(stack);
        System.out.println("Method pop");
        stack.pop();
        System.out.println(stack);*/
    }

}
