//现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。 
//
// 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。 
//
// 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。 
//
// 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。 
//
// 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。 
//
// 换句话说: 
//
// 
// 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。 
// 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。 
// 
//
// 书写满足这些限制条件的氢、氧线程同步代码。 
//
// 
//
// 示例 1: 
//
// 输入: "HOH"
//输出: "HHO"
//解释: "HOH" 和 "OHH" 依然都是有效解。
// 
//
// 示例 2: 
//
// 输入: "OOHHHH"
//输出: "HHOHHO"
//解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OH
//HOHH" 依然都是有效解。
// 
//
// 
//
// 提示： 
//
// 
// 输入字符串的总长将会是 3n, 1 ≤ n ≤ 50； 
// 输入字符串中的 “H” 总数将会是 2n 。 
// 输入字符串中的 “O” 总数将会是 n 。 
// 
// 👍 80 👎 0


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*class H2O {
    Lock lock = new ReentrantLock();
    Condition h2oFilled = lock.newCondition();
    Condition hEmpty = lock.newCondition();
    Condition oEmpty = lock.newCondition();
    int hCount = 0;
    int oCount = 0;
    Condition doneCondition = lock.newCondition();
    int hDoneCount = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "===hydrogen===");

            while (hCount == 2) {
                hEmpty.await();
            }

            hCount++;
            h2oFilled.signalAll();

            while (hCount < 2 || oCount < 1) {
                System.out.println(Thread.currentThread().getName() + " hydrogen == hcount:" + hCount + " oCount:" + oCount);
                h2oFilled.await();
            }

            System.out.println(Thread.currentThread().getName() + "=======print H===========");

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();

            hDoneCount++;
            doneCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "===oxygen===");

            while (oCount == 1) {
                oEmpty.await();
            }

            oCount++;
            h2oFilled.signalAll();

            while (hCount < 2 || oCount < 1) {
                System.out.println(Thread.currentThread().getName() + " oxygen == hcount:" + hCount + " oCount:" + oCount);
                h2oFilled.await();
            }

            System.out.println(Thread.currentThread().getName() + "=========print O=========");

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();

            while (hDoneCount != 2) {
                System.out.println(Thread.currentThread().getName() + "hDoneCount:" + hDoneCount);
                doneCondition.await();
            }
            hDoneCount = 0;
            hCount = 0;
            oCount = 0;
            hEmpty.signalAll();
            oEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }
}*/

class H2O {
    Semaphore hMax = new Semaphore(2);
    Semaphore oMax = new Semaphore(1);
    CyclicBarrier matchCount = new CyclicBarrier(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hMax.acquire();
        try {
            matchCount.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hMax.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oMax.acquire();
        try {
            matchCount.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oMax.release();
    }
}
