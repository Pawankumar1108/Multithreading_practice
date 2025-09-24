package thread_practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int availableBalance = 1000;

    private final Lock lock = new ReentrantLock();


        public void getBalance(int amount) {
            System.out.println(Thread.currentThread().getName() + "The Available Balance - " + amount);

            try {
                if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                    if(availableBalance>=amount){
                        try {
                            System.out.println(Thread.currentThread().getName() + "Withdrawal In Progress.. - " + amount);
                            Thread.sleep(3000);
                            availableBalance -= amount;
                            System.out.println(Thread.currentThread().getName() + "Withdrawal Completed & Remaining Available Balance - " + amount);
                        } catch (InterruptedException e) {
                        } finally {
                            lock.unlock();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + "Insufficient Balance.");
                    }
                }else {
                    System.out.println(Thread.currentThread().getName() + "Cound Not Accrued the locks, Will try later.");
                }
            } catch (InterruptedException e) {
            }

        }















//    public synchronized void getBalance(int amount){

//    public void getBalance(int amount) {
//        System.out.println(Thread.currentThread().getName() + "The Available Balance - " + amount);
//
//        if (availableBalance >= amount) {
//            System.out.println(Thread.currentThread().getName() + "Processing to Withdrawal Amount - " + amount);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//
//            }
//            availableBalance -= amount;
//            System.out.println(Thread.currentThread().getName() + "Completed Withdrawal,Remaining Balance :-  " + availableBalance);
//        } else {
//            System.out.println(Thread.currentThread().getName() + "Insufficient Balance in Account.");
//        }
//    }


}
