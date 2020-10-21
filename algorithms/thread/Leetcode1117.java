package thread;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: thread
 * @Author: elvis
 * @CreateTime: 2020-10-21 13:15
 * @Description: H2O 生成
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 *
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 *
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 *
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 *
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 * 换句话说:
 *
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 *
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 *
 *
 * 提示：
 *
 * 输入字符串的总长将会是 3n, 1 ≤ n ≤ 50；
 * 输入字符串中的 “H” 总数将会是 2n 。
 * 输入字符串中的 “O” 总数将会是 n 。
 */
public class Leetcode1117 {

     class H2O {
     private int hCount = 2;
     private int oCount = 1;

     public H2O() {

     }

         /**
          * 因为不限制 HHO形式　只要三个一组中两个H 一个O 所以严格控制数量hCount oCount
          * @param releaseHydrogen
          * @throws InterruptedException
          */
     public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
 		synchronized(this) {
             while (true) {
                 if (hCount > 0) {
                     // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                     releaseHydrogen.run();
                     hCount --;
                     if (hCount == 0 && oCount == 0) {
                         hCount = 2;
                         oCount = 1;
                     }
                     notifyAll();
                     break;
                 } else {
                     wait();
                 }
             }
         }
     }

         public void oxygen(Runnable releaseOxygen) throws InterruptedException {
         synchronized(this) {
             while (true) {
                 if (oCount > 0) {
                     // releaseOxygen.run() outputs "O". Do not change or remove this line.
 		            releaseOxygen.run();
                     oCount --;
                     if (hCount == 0 && oCount == 0) {
                         hCount = 2;
                         oCount = 1;
                     }
                     notifyAll();
                     break;
                 } else {
                     wait();
                 }
             }
         }
     }
 }
    class H2O2 {
        private boolean hFlag;
        private boolean oFlag;
        private int h = 2;
        public H2O2() {

        }

        /**
         * 用hFlag oFlag h=2控制先生成2个H 再生成一个O
         * @param releaseHydrogen
         * @throws InterruptedException
         */
        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized(this){
                while(hFlag){ // hFlag为true时，wait
                    wait();
                }
                releaseHydrogen.run();
                h--;
                if(h == 0){ // 当连续生产了两个H后，激活生产O
                    hFlag = true; // 关闭H
                    oFlag = true; // 激活O
                    h = 2;
                    notifyAll();
                }
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized(this){
                while(!oFlag){ // oFlag为false时，wait
                    wait();
                }
                releaseOxygen.run();
                hFlag = false;  // 激活H
                oFlag = false; // 关闭O
                notifyAll();
            }


        }
    }


}
