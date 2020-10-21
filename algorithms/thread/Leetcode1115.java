package thread;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: thread
 * @Author: elvis
 * @CreateTime: 2020-10-21 13:19
 * @Description: 交替打印FooBar
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */
public class Leetcode1115 {

    class FooBar {
        private int n;
        private Boolean fooPrinted = false;

        public FooBar(int n) {
            this.n = n;
        }

        /**
         * 通过标志位flag判断foo是否打印　bar打印前检查标志位　foo是否已经打印
         * @param printFoo
         * @throws InterruptedException
         */
        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized(this) {
                    if(fooPrinted) {
                        wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    fooPrinted = !fooPrinted;
                    notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized(this) {
                    if(!fooPrinted) {
                        wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooPrinted = !fooPrinted;
                    notify();
                }
            }
        }
    }
}
