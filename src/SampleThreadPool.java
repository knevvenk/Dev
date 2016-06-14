import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bandi on 3/19/2016.
 */
public class SampleThreadPool {

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i<10;i++) {
            Runnable r = new WorkerThread("run " + i);
            executor.submit(r);
        }
        executor.shutdown();
    }
}

class WorkerThread implements Runnable
{
    private String s;

    WorkerThread(String s){
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start "+s);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " end ");
    }

    public String toString(){
        return s;
    }
}
