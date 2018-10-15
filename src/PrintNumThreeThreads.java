
public class PrintNumThreeThreads {	
	int count =1;
	Object lock = new Object();
	public static void main(String[] args) {
		
		
		PrintNumThreeThreads print = new PrintNumThreeThreads();
		Thread t1 = new Thread(print.new NumPrinter(10, 1));
		Thread t2 = new Thread(print.new NumPrinter(10, 0));
//		Thread t3 = new Thread(print.new NumPrinter(10, 0));
		
		t1.start();
		t2.start();
//		t3.start();
	}
	
	class NumPrinter implements Runnable{
		int size;
		int threadId;
		
		public NumPrinter(int size, int threadId) {
			this.size = size;
			this.threadId = threadId;
		}
		@Override
		public void run() {		
			while(count<=size) {
				synchronized (lock) {
					if(count%2 != threadId) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						System.out.println("Thread Id :: "+threadId+" and Number is :: "+count++);
						lock.notifyAll();
					}
				}
			}
		}
		
	}
}




