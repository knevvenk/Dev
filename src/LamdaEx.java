/**
 * Created by bandi on 1/7/2016.
 */

interface Executable{
    void execute(String s);    
}

class Runner{
    public void run(Executable e){
        System.out.println("In run method");
        e.execute("venkat");
    }
}
public class LamdaEx {
    public static void main(String[] args) {
         int i = 10;
        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public void execute(String s) {
                System.out.println("In executable method "+s+" "+i);
            }
        });

        System.out.println("================================");
        runner.run((String s1) -> System.out.println("In lamdaEx execute method "+s1+" "+i));
//        i =9;
    }
}
