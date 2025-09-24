import thread_practice.BankAccount;
import thread_practice.World;


public class Main {
    public static void main(String[] args) {

        System.out.println("welcome Pawan !");

//        World world = new World();
//        System.out.println(world.getState());
//        world.start();
//        System.out.println(world.getState());

        BankAccount bankAccount = new BankAccount();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bankAccount.getBalance(500);

            }
        };
        Thread th1 = new Thread(runnable,"The 1st Thread Withdraw :- ");
        Thread th2 = new Thread(runnable,"The 2nd Thread Withdraw :- ");
        th1.start();
        th2.start();
    }

}