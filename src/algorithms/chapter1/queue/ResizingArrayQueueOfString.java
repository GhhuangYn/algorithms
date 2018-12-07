package algorithms.chapter1.queue;

/**
 * @Description: 使用定常数组实现队列的抽象
 * @author: HuangYn
 * @date: 2018/12/7 9:41
 */
public class ResizingArrayQueueOfString {

    private String[] queue = new String[3];
    private int last = 0;
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == queue.length;
    }

    public void resize(int max) {
        String[] tmp = new String[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = queue[i];
        }
        queue = tmp;
    }

    public void enqueue(String elem) {
        if (isFull()) {
            resize(2 * queue.length);
        }
        if (isEmpty()) {
            queue[0] = elem;
        } else {
            queue[++last] = elem;
        }
        N++;
    }

    public String dequeue() {
        if (isEmpty()) return null;
        String elem = queue[0];
        for (int i = 1; i < N; i++) {
            queue[i - 1] = queue[i];
        }
        last--;
        N--;
        return elem;
    }

    public static void main(String[] args) {

        ResizingArrayQueueOfString queueOfString = new ResizingArrayQueueOfString();
        queueOfString.enqueue("aa");
        queueOfString.enqueue("bb");
        queueOfString.enqueue("dd");
        System.out.println(queueOfString.dequeue());
        System.out.println(queueOfString.dequeue());
        queueOfString.enqueue("cc");
        System.out.println(queueOfString.dequeue());
        System.out.println(queueOfString.dequeue());
        System.out.println(queueOfString.dequeue());
    }

}
