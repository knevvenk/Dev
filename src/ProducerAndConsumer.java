import java.util.concurrent.*;

/**
 * Created by bandi on 3/19/2016.
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
        System.out.println("Done");


    }
}

class Producer implements Runnable{

    BlockingQueue queue;
    Producer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Producing "+i);
                queue.put(i);
            }
        }catch (InterruptedException ir){
            ir.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    BlockingQueue queue;
    Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Consuming " + queue.take());
            } catch (InterruptedException ir) {
                ir.printStackTrace();
            }
        }
    }
}