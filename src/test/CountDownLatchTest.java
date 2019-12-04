package test;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchTest
 * @Description CountDownLatch测试
 * @Author Administrator
 * @Date 2019/11/25 14:47
 * @Version 1.0
 */
public class CountDownLatchTest {

	static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "计数器减一");
			countDownLatch.countDown();

		}).start();
		new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "计数器减一");
			countDownLatch.countDown();

		}).start();

		try {
			countDownLatch.await();
			System.out.println("开始执行后续操作");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
